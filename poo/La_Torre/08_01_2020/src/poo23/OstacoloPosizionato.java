package poo23;

public class OstacoloPosizionato extends Ostacolo{
	private Posizione posizone;

	public OstacoloPosizionato(int numeroElementi, Categoria categoria, Posizione posizone) {
		super(numeroElementi, categoria);
		this.posizone = posizone;
	}

	public Posizione getPosizione() {
		return posizone.clone();
	}
	
	
}
