package esercizio2;


public class PuntoMappa{
	private int latitudine;
	private int longitudine;
	
	public PuntoMappa(int unaLatitudine, int unaLongitudine){
		latitudine=unaLatitudine;
		longitudine=unaLongitudine;
	}
	
	public String toString(){
		return getClass().getName() + "[latitudine="+latitudine+",longitudine="+longitudine+"]";		
	}
	
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		PuntoMappa tmp = (PuntoMappa) obj;
		return (latitudine==tmp.latitudine) && (longitudine==tmp.longitudine);
	}
	
	
	//metodi di accesso
	
	public int getLatitudine(){
		return latitudine;
	}
	
	public int getLongitudine(){
		return longitudine;
	}

	//metodi modificatori
	
	public void setLatitudine(int l){
		latitudine=l;
	}
	
	public void setLongitudine(int l){
		longitudine=l;
	}
}
