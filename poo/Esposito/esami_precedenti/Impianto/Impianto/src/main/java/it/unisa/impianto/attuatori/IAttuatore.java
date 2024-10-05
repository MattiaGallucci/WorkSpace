package it.unisa.impianto.attuatori;

public interface IAttuatore {
	public void positiveAction();
	public void negativeAction();
	public void stop(boolean isPositive);
	public double getConsumption();
}
