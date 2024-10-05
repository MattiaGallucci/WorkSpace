package poo23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Animale animale = new Animale("BOH");
		Cane cane = new Cane("CANE");
		Gatto gatto = new Gatto("GATTO");
		Coccodrillo coccodrillo = new Coccodrillo("COCCODRILLO");
		Labrador labradoro = new Labrador("LABRADOR");
		
		List<Object> oggetti = new ArrayList<>();
		List<Animale> animali = new ArrayList<Animale>();
		List<Cane> cani = new ArrayList<Cane>();
		List<Gatto> gatti = new ArrayList<Gatto>();
		List<Labrador> labrador = new ArrayList<Labrador>();
		List<Coccodrillo> coccodrilli = List.of(coccodrillo);
		animali = Arrays.asList(animale);
		cani.add(cane);
		gatti.add(gatto);
		
		leggi(animali);
		leggi(cani);
		
		/*scrivi(animali, animale);
		scrivi(animali, cane);
		scrivi(cani, cane);
		scrivi(cani, animale);*/
		
		// scrivi2(animali);
		
		List<? extends Animale> lista = new ArrayList<>();
		lista = cani;
		
		List<? super Animale> lista2 = new ArrayList<>();
		lista2 = oggetti;
		scrivi2(lista2);
	}
	
	public static void leggi(List<? extends Animale> lista) {
		for(Animale a : lista)
			a.verso();
	}
	
	public static void scrivi(List<? super Animale> lista, Animale a) {
		lista.add(a);
	}
	
	public static void scrivi2(List<? super Animale> lista) {
		lista.add(new Animale("ADD"));
	}
}
