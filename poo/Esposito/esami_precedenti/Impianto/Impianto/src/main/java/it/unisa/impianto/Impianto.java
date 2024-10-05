package it.unisa.impianto;

import java.util.Collection;
import java.util.HashMap;

import it.unisa.impianto.attuatori.IAttuatore;
import it.unisa.impianto.attuatori.Riscaldamento;
import it.unisa.impianto.comandi.CommandRiscaldamentoCaldo;
import it.unisa.impianto.comandi.CommandRiscaldamentoFreddo;
import it.unisa.impianto.comandi.ICommand;
import it.unisa.impianto.sensori.Sensor;
import it.unisa.impianto.sensori.SensoreTemperatura;

public class Impianto {
	private HashMap<String, Sensor<?> > sensori;
	private HashMap<String, IAttuatore> attuatori;
	private DomoticServer server;
	private String indirizzo;
	
	protected Impianto(DomoticServer server, String indirizzo) {
		this.server = server;
		sensori = new HashMap<>();
		attuatori = new HashMap<>();
		this.indirizzo = indirizzo;
	}
	
	@SuppressWarnings("deprecation")
	public void aggiungiSensore(String nome, Sensor<?> sensore) {
		if(!sensori.containsKey(nome)) {
			sensori.put(nome, sensore);
			sensore.addObserver(server);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void rimuoviSensore(String nome) {
		Sensor<?> sensore = sensori.get(nome);
		sensore.deleteObserver(server);
		sensori.remove(nome);
	}
	
	public Sensor<?> getSensore(String nome) {
		return sensori.get(nome);
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public DomoticServer getServer() {
		return server;
	}
	
	public void aggiungiAttuatore(String nome, IAttuatore attuatore) {
		if(!attuatori.containsKey(nome)) {
			attuatori.put(nome, attuatore);
		}
	}
	
	public IAttuatore rimuoviAttuatore(String nome) {
		return attuatori.remove(nome);
	}
	
	public IAttuatore getAttuatore(String nome) {
		return attuatori.get(nome);
	}
	
	public Collection<IAttuatore> getAttuatori() {
		return attuatori.values();
	}
	
	
	@SuppressWarnings("deprecation")
	public static Impianto makeImpianto(String indirizzo) {
		Impianto impianto = new Impianto(new DomoticServer(), indirizzo);
		SensoreTemperatura sens2 = new SensoreTemperatura(18.0);
		sens2.addObserver(impianto.getServer());
		impianto.aggiungiSensore("Temp", sens2);
		
		Riscaldamento riscaldamento = new Riscaldamento(sens2);
		impianto.aggiungiAttuatore("riscaldamento", riscaldamento);
		
		ICommand cmd1 = new CommandRiscaldamentoCaldo(riscaldamento);
		impianto.getServer().addComando(cmd1, "SensoreTemperatura");
		ICommand cmd2 = new CommandRiscaldamentoFreddo(riscaldamento);
		impianto.getServer().addComando(cmd2, "SensoreTemperatura");
		
		return impianto;
	}
}
