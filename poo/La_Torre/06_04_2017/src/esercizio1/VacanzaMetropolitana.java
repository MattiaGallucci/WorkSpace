package esercizio1;

public class VacanzaMetropolitana extends Vacanza implements Cloneable {
	private Card card;

	public VacanzaMetropolitana(int id, int costo, String descrizione, Card card) {
		super(id, card.getCosto(), descrizione);
		this.card = card;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String toString() {
		return super.toString() + "[card=" + card + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;

		VacanzaMetropolitana vm = (VacanzaMetropolitana) obj;
		return card.equals(vm.card);
	}

	public VacanzaMetropolitana clone() {
		VacanzaMetropolitana vmc = (VacanzaMetropolitana) super.clone();
		vmc.card = card.clone();
		return vmc;
	}

}
