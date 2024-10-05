package it.unisa.impianto.comandi;

public interface ICommand {
	public boolean checkExecution(Object... args);
	public void execute();
	public void turnOff();
	
	public default String getName() {
		return this.getClass().getName();
	}
}
