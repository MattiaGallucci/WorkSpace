package it.unisa.covid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import org.apache.commons.io.input.CloseShieldInputStream;

public class Vaccinato {
	private final String CF;
	private String nome;
	private String cognome;
	private int anno;
	private Vaccino vaccino;
	private Date data_prima_dose, data_seconda_dose;
	
	public Vaccinato(String cF, String nome, String cognome, int anno) {
		super();
		CF = cF;
		this.nome = nome;
		this.cognome = cognome;
		this.anno = anno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Vaccino getVaccino() {
		return vaccino;
	}

	public void setVaccino(Vaccino vaccino) {
		if(this.vaccino == null)
			this.vaccino = vaccino;
	}

	public Date getData_prima_dose() {
		return data_prima_dose;
	}

	public void setData_prima_dose(Date data_prima_dose) throws Exception {
		if((this.data_prima_dose == null) && (this.vaccino != null)) {
			if(this.anno >= this.vaccino.getLimiteAnno())
				this.data_prima_dose = data_prima_dose;
			else
				throw new Exception("Limite et� non rispettato");
		}
	}

	public Date getData_seconda_dose() {
		return data_seconda_dose;
	}

	public void setData_seconda_dose(Date data_seconda_dose) throws Exception {
		if((this.data_prima_dose != null) && (this.vaccino.getNumeroDosi() > 1))
			this.data_seconda_dose = data_seconda_dose;
		else
			throw new Exception("Seconda dose non inseribile");
	}

	public String getCF() {
		return CF;
	}
	
	public static Vaccinato crea(InputStream in) {
		Scanner scan = new Scanner(new BufferedReader(
				new InputStreamReader(CloseShieldInputStream.wrap(in))));
		String nome, cognome, cf, vaccino, data;
		int anno;
		Date data1,data2;
			
		System.out.println("Inserire un nome di un vaccinato");
		nome = scan.nextLine();
		System.out.println("Inserire un cognome di un vaccinato");
		cognome = scan.nextLine();
		System.out.println("Inserire un cf di un vaccinato");
		cf = scan.nextLine();
		System.out.println("Inserire eta\' di un vaccinato");
		anno = Integer.parseInt (scan.nextLine());
		Vaccinato vaccinato = new Vaccinato(cf, nome, cognome, anno);
			
		System.out.println("Inserire tipo vaccino di un vaccinato " + Arrays.toString(Vaccino.values()));
		vaccino = scan.nextLine();
		vaccinato.setVaccino(Vaccino.valueOf(Vaccino.class, vaccino));
		if(vaccinato.getVaccino()== null)
			System.out.println("Vaccino non riconosciuto");
		else {		
			System.out.println("Inserire data prima dose di un vaccinato");
			data = scan.nextLine();
			try {
				data1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);
				vaccinato.setData_prima_dose(data1);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}  
			    
			System.out.println("Inserire data seconda dose di un vaccinato");
			data = scan.nextLine();
			try {
				data2 = new SimpleDateFormat("dd/MM/yyyy").parse(data);
				vaccinato.setData_seconda_dose(data2);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		scan.close();
		return vaccinato;
	}

	@Override
	public String toString() {
		return "Vaccinato [CF=" + CF + ", nome=" + nome + ", cognome=" + cognome + ", anno=" + anno + ", vaccino="
				+ vaccino + ", data_prima_dose=" + data_prima_dose + ", data_seconda_dose=" + data_seconda_dose + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CF);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaccinato other = (Vaccinato) obj;
		return Objects.equals(CF, other.CF);
	}
}
