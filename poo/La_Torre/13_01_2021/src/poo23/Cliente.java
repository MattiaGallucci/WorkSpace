package poo23;

public class Cliente {
	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public double acquista(double prezzo) {
		if(this instanceof ClienteOrdinario) {
			ClienteOrdinario c = (ClienteOrdinario) this;
			int numeroVolteApplicabile=0;
			for(int i=0; i<5 && c.getPunti()>=5; i++) {
				numeroVolteApplicabile++;
				c.rimuoviPunti(5);
			}
			c.aggiungiPunti(1);
			return prezzo - prezzo*0.02*numeroVolteApplicabile;
		}
		else if (this instanceof ClienteOro) {
			ClienteOro cOro = (ClienteOro) this;
			if(prezzo < cOro.getBonus()) {
				cOro.scalaBonus((int)prezzo);
				return 0.0;
			}
			else {
				prezzo -= cOro.getBonus();
				cOro.setBonus(0);;
				return prezzo*0.9;
			}
		}
		return 0.0;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "]";
	}
	
	
	
}
