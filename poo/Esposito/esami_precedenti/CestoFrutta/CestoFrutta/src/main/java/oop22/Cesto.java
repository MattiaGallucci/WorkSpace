package oop22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Cesto<T extends Frutta> {
	private List<T> frutti;
	
	static class TroppoPesoException extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	public Cesto() {
		frutti = new ArrayList<>();
	}
	
	public Cesto(@SuppressWarnings("unchecked") T... frutti) {
		this();
		this.frutti.addAll(Arrays.asList(frutti));
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
			frutti.add(frutto);
	}
	
	public void aggiungi (List<T> listaFrutti) throws TroppoPesoException {
		//for(T frutta : listaFrutti)
		//	aggiungi(frutta);
		
		if(getPeso() + getPeso(listaFrutti) > 5)
			throw new TroppoPesoException();
		else 
			this.frutti.addAll(listaFrutti);
	}
	
	public List<T> pesanti() {
		return frutti.stream().sorted(Comparator.comparing(Frutta::getPeso).reversed()).limit(2).toList();
	}
	
	public List<T> getFrutta() {
		return frutti;
	}
	
	public static void main(String[] args) {
		try {
			Cesto<Mela> cesto = new Cesto<>(new Mela(0.5), new Mela(2), new Mela(3));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Cesto<Mela> cesto = new Cesto<>(new Mela(0.5), new Mela(0.8), new Mela(2));
		try {
			cesto.aggiungi(new Mela(1));
		} catch (TroppoPesoException e) {
			e.printStackTrace();
		}
		Optional<List<Mela>> op = Optional.ofNullable(cesto.pesanti());
		op.ifPresent(l -> l.stream().forEach(System.out::println));
		
		Cesto<Mela> cesto2 = new Cesto<>();
		Optional.ofNullable(cesto2.pesanti()).ifPresent(l -> l.stream().forEach(System.out::println));
		
		Cesto<Frutta> cestoGen = new Cesto<>(new Mela(0.5), new Arancia(0.8), new Pesca(2));
		cestoGen.getFrutta().stream().forEach(System.out::println);
	}
}
