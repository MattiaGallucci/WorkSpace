package oop22;

//import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CestoNew<T extends Frutta> {
	private List<T> frutti;
	private Class<? extends T> tipoFrutta;
	
	static class TroppoPesoException extends Exception {

		private static final long serialVersionUID = 1L;
		
	}
	
	public CestoNew(Class<? extends T> tipo) {
		frutti = new ArrayList<>();
		tipoFrutta = tipo;
		
		/*
		int mode = tipo.getClass().getModifiers();
		if(Modifier.isAbstract(mode))
			throw new IllegalArgumentException();*/
	}
	
	public CestoNew(Class<? extends T> tipo, @SuppressWarnings("unchecked") T... frutti) {
		this(tipo);
		if(Arrays.asList(frutti).stream().map(Object::getClass).distinct().count() > 1) 
			throw new IllegalArgumentException();
		else 
			if(Arrays.asList(frutti).stream().map(Object::getClass).distinct().limit(1).findAny().get().equals(tipoFrutta))
				this.frutti.addAll(Arrays.asList(frutti));
			else
				throw new IllegalArgumentException();
		if(checkLimit())
			throw new IllegalArgumentException("Too heavy");
	}
	
	private boolean checkLimit() {
		return getPeso() > 5;
	}
	
	public double getPeso() {
		return frutti.stream().mapToDouble(Frutta::getPeso).sum();
	}
	
	public static <T extends Frutta> double getPeso(List <T> frutti) {
		return frutti.stream().mapToDouble(Frutta::getPeso).sum();
	}
	
	public void aggiungi (T frutto) throws TroppoPesoException {
		if(getPeso() + frutto.getPeso() > 5)
			throw new TroppoPesoException();
		else
			if(frutto.getClass().equals(tipoFrutta))
				frutti.add(frutto);
			else
				throw new IllegalArgumentException();
	}
	
	public void aggiungi (List<T> listaFrutti) throws TroppoPesoException {
		//for(T frutta : listaFrutti)
		//	aggiungi(frutta);
		
		if(getPeso() + getPeso(listaFrutti) > 5)
			throw new TroppoPesoException();
		else 
			if(listaFrutti.stream().map(Object::getClass).distinct().count() > 1) 
				throw new IllegalArgumentException();
			else 
				if(listaFrutti.stream().map(Object::getClass).distinct().limit(1).findAny().get().equals(tipoFrutta))
					this.frutti.addAll(listaFrutti);
				else
					throw new IllegalArgumentException();
	}
	
	public List<T> pesanti() {
		return frutti.stream().sorted(Comparator.comparing(Frutta::getPeso).reversed()).limit(2).toList();
	}
	
	public List<T> getFrutta() {
		return frutti;
	}
	
	public static void main(String[] args) {
		try {
			CestoNew<Mela> cesto = new CestoNew<>(Mela.class, new Mela(0.5), new Mela(2), new Mela(3));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		CestoNew<Mela> cesto = new CestoNew<>(Mela.class, new Mela(0.5), new Mela(0.8), new Mela(2));
		try {
			cesto.aggiungi(new Mela(1));
		} catch (TroppoPesoException e) {
			e.printStackTrace();
		}
		Optional<List<Mela>> op = Optional.ofNullable(cesto.pesanti());
		op.ifPresent(l -> l.stream().forEach(System.out::println));
		
		CestoNew<Mela> cesto2 = new CestoNew<>(Mela.class);
		Optional.ofNullable(cesto2.pesanti()).ifPresent(l -> l.stream().forEach(System.out::println));
		
		CestoNew<Frutta> cestoGen = new CestoNew<>(Mela.class, new Mela(0.5), new Arancia(0.8), new Pesca(2));
		cestoGen.getFrutta().stream().forEach(System.out::println);
	}
}
