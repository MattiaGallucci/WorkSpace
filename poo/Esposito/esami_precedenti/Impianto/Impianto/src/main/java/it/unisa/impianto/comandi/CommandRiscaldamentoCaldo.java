package it.unisa.impianto.comandi;

import it.unisa.impianto.attuatori.Riscaldamento;
import it.unisa.impianto.sensori.SensoreTemperatura;

public class CommandRiscaldamentoCaldo implements ICommand {
	private Riscaldamento ris;
	
	public CommandRiscaldamentoCaldo(Riscaldamento ris) {
		this.ris = ris;
	}

	@Override
	public void execute() {
		System.out.println("Riscaldamento azione positiva");
		ris.positiveAction();
	}

	@Override
	public boolean checkExecution(Object... args) {
		if(args.length == 2) {
			try {
				SensoreTemperatura target = SensoreTemperatura.class.cast(args[0]);
				Double value = Double.class.cast(args[1]);
				return target.isAllowed(value, false);
			} catch(ClassCastException ex) {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public void turnOff() {
		ris.stop(true);
	}
}
