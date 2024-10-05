package it.unisa.impianto.comandi;

import it.unisa.impianto.attuatori.Riscaldamento;
import it.unisa.impianto.sensori.SensoreTemperatura;

public class CommandRiscaldamentoFreddo implements ICommand {
	private Riscaldamento ris;
	
	public CommandRiscaldamentoFreddo(Riscaldamento ris) {
		this.ris = ris;
	}

	@Override
	public void execute() {
		System.out.println("Riscaldamento azione negativa");
		ris.negativeAction();
	}

	@Override
	public boolean checkExecution(Object... args) {
		if(args.length == 2) {
			try {
				SensoreTemperatura target = SensoreTemperatura.class.cast(args[0]);
				Double value = Double.class.cast(args[1]);
				return target.isAllowed(value, true);
			} catch(ClassCastException ex) {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public void turnOff() {
		ris.stop(false);
	}
}
