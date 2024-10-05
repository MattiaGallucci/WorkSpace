package poo23;

public class ClienteOro extends Cliente{
	private int bonus = 100;

	public ClienteOro(String nome) {
		super(nome);
	}
	
	public int getBonus() {
		return bonus;
	}
	
	public void setBonus(int x) {
		bonus = x;
	}
	
	public void scalaBonus(int prezzo) {
		bonus -= prezzo;
	}

	/*public double acquista(double prezzo) {
		if(prezzo < bonus) {
			bonus -= prezzo;
			return 0.0;
		}
		else {
			prezzo -= bonus;
			bonus = 0;
			return prezzo*0.9;
		}
	}*/

	@Override
	public String toString() {
		return "ClienteOro [" + super.toString() + " bonus=" + bonus + "]";
	}
	
	
}
