package it.unisa.impianto;

import java.util.ArrayList;
import java.util.List;

import it.unisa.impianto.attuatori.IAttuatore;
import it.unisa.impianto.sensori.SensoreTemperatura;

public class MainApp {

	public static void main(String[] args) {
		final List<Impianto> organizzazione = new ArrayList<>();
		Impianto impianto1 = Impianto.makeImpianto("via Roma, 4 - Salerno");
		organizzazione.add(impianto1);
		Impianto impianto2 = Impianto.makeImpianto("piazza Concordia, 1 - Salerno");
		organizzazione.add(impianto2);
		Impianto impianto3 = Impianto.makeImpianto("via Napoli, 17 - Fisciano");
		organizzazione.add(impianto3);
		Impianto impianto4 = Impianto.makeImpianto("piazza Cavour, 81 - Cava de Tirreni");
		organizzazione.add(impianto4);
		Impianto impianto5 = Impianto.makeImpianto("piazza del Carmine, 18 - Salerno");
		organizzazione.add(impianto5);
	
		Thread[] th = new Thread[5];
		th[0] = new Thread(() -> {
			Impianto impianto = organizzazione.get(0);
			SensoreTemperatura sens = (SensoreTemperatura) impianto.getSensore("Temp");
			sens.setState(28.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sens.setState(18.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Consumo Energetico dell'Impianto sito in " + impianto.getIndirizzo() + " : "
					+ impianto.getAttuatori().stream().mapToDouble(IAttuatore::getConsumption).sum());
		});
		th[0].start();
		
		th[1] = new Thread(() -> {
			Impianto impianto = organizzazione.get(1);
			SensoreTemperatura sens = (SensoreTemperatura) impianto.getSensore("Temp");
			sens.setState(29.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sens.setState(15.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Consumo Energetico dell'Impianto sito in " + impianto.getIndirizzo() + " : "
					+ impianto.getAttuatori().stream().mapToDouble(IAttuatore::getConsumption).sum());
		});
		th[1].start();
		
		th[2] = new Thread(() -> {
			Impianto impianto = organizzazione.get(2);
			SensoreTemperatura sens = (SensoreTemperatura) impianto.getSensore("Temp");
			sens.setState(27.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sens.setState(17.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Consumo Energetico dell'Impianto sito in " + impianto.getIndirizzo() + " : "
					+ impianto.getAttuatori().stream().mapToDouble(IAttuatore::getConsumption).sum());
		});
		th[2].start();
		
		th[3] = new Thread(() -> {
			Impianto impianto = organizzazione.get(3);
			SensoreTemperatura sens = (SensoreTemperatura) impianto.getSensore("Temp");
			sens.setState(26.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sens.setState(13.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Consumo Energetico dell'Impianto sito in " + impianto.getIndirizzo() + " : "
					+ impianto.getAttuatori().stream().mapToDouble(IAttuatore::getConsumption).sum());
		});
		th[3].start();
		
		th[4] = new Thread(() -> {
			Impianto impianto = organizzazione.get(4);
			SensoreTemperatura sens = (SensoreTemperatura) impianto.getSensore("Temp");
			sens.setState(25.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sens.setState(25.0);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Consumo Energetico dell'Impianto sito in " + impianto.getIndirizzo() + " : "
					+ impianto.getAttuatori().stream().mapToDouble(IAttuatore::getConsumption).sum());
		});
		th[4].start();
		
		for(int i = 0; i < th.length; i++) {
			try {
				th[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Consumo Energetico degli impianti di Salerno : "
				+ organizzazione.stream().filter(i -> i.getIndirizzo().contains("- Salerno")).mapToDouble(i -> i.getAttuatori().stream().mapToDouble(IAttuatore::getConsumption).sum()).sum());
		
		System.out.println("Numero impianti inattivi a Salerno : "
				+ organizzazione.stream().filter(i -> i.getIndirizzo().contains("- Salerno")).mapToDouble(i -> i.getAttuatori().stream().mapToDouble(IAttuatore::getConsumption).sum()).filter(d -> d == 0).count());
		
		System.out.println("Numero impianti attivi a Salerno : "
				+ organizzazione.stream().filter(i -> i.getIndirizzo().contains("- Salerno")).mapToDouble(i -> i.getAttuatori().stream().mapToDouble(IAttuatore::getConsumption).sum()).filter(d -> d > 0).count());
	}

}
