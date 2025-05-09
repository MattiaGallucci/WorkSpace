package esercizio1;

import java.util.ArrayList;

public class Centri<T extends CentroUrbano> {
	private ArrayList<T> centri;
	
	public Centri(){
		centri=new ArrayList<>();
	}
	
	public void aggiungi(T x){
		int i = cerca(x.getNome());
		if (i== -1)	centri.add((T)x.clone());
	}
	
	private int cerca(String unNome) {
		int i;
		for(i=0; i<centri.size(); i++)
			if(centri.get(i).getNome().equalsIgnoreCase(unNome) )
				return i;
	    return -1;
	}
	
	public void cancella(String unNome){
		int i = cerca(unNome);
		if (i!= -1) {
			 centri.remove(i);
		}
	}
	
	public T getCentro(String unNome){
		int i = cerca(unNome);
		if (i!= -1) {
			T found = centri.get(i);
			 return (T) found.clone();
		}
		return null;
	}
	
	public int getAbitantiCentro(String unNome){
		int i = cerca(unNome);
		if (i!= -1) {
			 return centri.get(i).getAbitanti();
		}
		return -1;
	}
	
	public Centri<T> clone() {
		try {
			Centri<T> c = (Centri<T>) super.clone();
			c.centri = new ArrayList<T>();
			for(T elem : centri) {
				c.centri.add((T) elem.clone());
			}
			return c;
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	public int getSize(){
		return centri.size();
	}

}
