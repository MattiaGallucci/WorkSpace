package it.unisa.impianto.attuatori;

import java.time.Duration;
import java.time.LocalDateTime;
import it.unisa.impianto.sensori.SensoreTemperatura;

public class Riscaldamento implements IAttuatore {
	private double value;
	private boolean isPositive, isOn;
	private final double coeff = 0.15;
	private SensoreTemperatura sens;
	private LocalDateTime startTime;
	private double energyConsumption;
	
	public Riscaldamento(SensoreTemperatura sens) {
		value = 0;
		this.sens = sens;
		startTime = null;
		energyConsumption = 0;
		isOn = false;
		isPositive = false;
	}

	@Override
	public void positiveAction() {
		value = sens.getState();
		if(value < 30) {
			if(startTime == null) {
				startTime = LocalDateTime.now(); 
				isOn = true;
				isPositive = true;
			}
			value += 1;
			System.out.println("Riscaldamento più caldo");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sens.setState(value);
		} 
	}

	@Override
	public void negativeAction() {
		value = sens.getState();
		if(value > -10) {
			if(startTime == null) {
				startTime = LocalDateTime.now(); 
				isOn = true;
				isPositive = false;
			}
			value -= 1;
			System.out.println("Riscaldamento più freddo");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sens.setState(value);
		}
	}
	
	@Override
	public void stop(boolean isPositive) {
		if((isOn == false) || (isPositive != this.isPositive))
			return;
		
		if(startTime != null) {
			LocalDateTime endTime = LocalDateTime.now(); 
			double diff = Duration.between(startTime, endTime).getSeconds();
			energyConsumption += (coeff * diff);
			startTime =  null;
		}
	}
	
	@Override
	public double getConsumption() {
		return energyConsumption;
	}
}
