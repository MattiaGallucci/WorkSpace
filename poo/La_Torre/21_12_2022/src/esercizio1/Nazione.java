package esercizio1;

public final class Nazione implements Cloneable{
	private final String nome;
	private final int numeroAbitanti;
	
	public Nazione(String unNome, int unNumeroAbitanti){
		nome=unNome;
		numeroAbitanti=unNumeroAbitanti;
	}
	
	public String toString(){
		return getClass().getName() + "[nome="+nome+",numeroAbitanti="+numeroAbitanti+"]";		
	}
	
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Nazione tmp = (Nazione) obj;
		return nome.equals(tmp.nome) && (numeroAbitanti==tmp.numeroAbitanti);
	}
	
	public Nazione clone() {
		try {
			return (Nazione)super.clone();
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
		
	//metodi di accesso
	
	public String getNome(){
		return nome;
	}
	
	public int getNumeroAbitanti(){
		return numeroAbitanti;
	}
	
	//metodi modificatori
	
	public void changeNumeroAbitanti(int newNumeroAbitanti){
		new Nazione(nome, newNumeroAbitanti);
	}

}
