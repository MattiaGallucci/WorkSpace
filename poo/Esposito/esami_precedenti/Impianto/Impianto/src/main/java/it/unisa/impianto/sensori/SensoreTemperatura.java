package it.unisa.impianto.sensori;

public class SensoreTemperatura extends Sensor<Double> {
	private Double value;
	
	public SensoreTemperatura(Double initialValue) {
		value = initialValue;
		obj = Double.class;
	}

	@Override
	public void setState(Double value) {
		if((value > -20.0) && (value < 100.0)) {
			this.value = value;
			System.out.println("Temperatura registrata pari a " + value);
			this.notifica();
		}
	}

	@Override
	public Double getState() {
		return value;
	}
	
	public boolean isAllowed(Double value, boolean isHot) {
		if(isHot)
			return value > 25.0;
		else
			return value < 25.0;
	}
}
