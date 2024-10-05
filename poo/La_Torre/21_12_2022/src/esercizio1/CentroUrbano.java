package esercizio1;

public class CentroUrbano implements Cloneable{
	private String nome;
	private Nazione nazione;
	private int numeroAbitanti;
	private double temperatura;
	
	public CentroUrbano(String unNome, Nazione unaNazione, int unNumeroAbitanti, double unaTemperatura){
		nome=unNome;
		nazione=unaNazione;
		numeroAbitanti=unNumeroAbitanti;
		temperatura=unaTemperatura;
	}
	
	public String toString(){
		return getClass().getName() + "[nome="+nome+",nazione="+nazione+",numeroAbitanti="+numeroAbitanti+",temperatura="+temperatura+"]";		
	}
	
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		CentroUrbano tmp = (CentroUrbano) obj;
		return nome.equals(tmp.nome) && (nazione==tmp.nazione) && (numeroAbitanti==tmp.numeroAbitanti) && (temperatura==tmp.temperatura);
	}
	
	public CentroUrbano clone() {
		try {
			CentroUrbano c = (CentroUrbano) super.clone();
			c.nazione = nazione.clone();
			return c;
		} catch (CloneNotSupportedException e) {
			return null;
		}
		
	}
	
	
	//metodi modificatori
	
	public void changeTemperatura(double newTemperatura){
		temperatura=newTemperatura;
	}
	
	public void changeNumeroAbitanti(int newNumeroAbitanti){
		numeroAbitanti=newNumeroAbitanti;
	}
	
	//metodi di accesso
	
	public Nazione getNazione(){
		return nazione;
	}
	
	public String getNome(){
		return nome;
	}

	public int getAbitanti(){
		return numeroAbitanti;
	}
	
	public double getTemperatura(){
		return temperatura;
	}
}
