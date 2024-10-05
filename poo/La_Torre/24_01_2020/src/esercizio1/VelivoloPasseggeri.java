package esercizio1;

public class VelivoloPasseggeri extends Velivolo{
	private int posti;
	private int[][] postiLiberi;
	private Pilota pilota;
	
	public VelivoloPasseggeri(String codice, int pesoMassimo, Certificato certificato, int posti, int[][] postiLiberi,
			Pilota pilota) {
		super(codice, pesoMassimo, certificato);
		this.posti = posti;
		this.postiLiberi = postiLiberi;
		this.pilota = pilota;
	}
	
	
}
