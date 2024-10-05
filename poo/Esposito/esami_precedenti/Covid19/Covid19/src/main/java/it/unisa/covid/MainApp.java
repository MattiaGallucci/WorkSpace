package it.unisa.covid;

public class MainApp {

	public static void main(String[] args) {
		CentroVaccinale centro = new CentroVaccinale("Fisciano");
		centro.insert(Vaccinato.crea(System.in));
		centro.insert(Vaccinato.crea(System.in));
		centro.insert(Vaccinato.crea(System.in));
		
		centro.saveOnFile("centro.txt");
	}

}
