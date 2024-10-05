package it.unisa.impianto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import it.unisa.impianto.comandi.ICommand;
import it.unisa.impianto.sensori.Sensor;

@SuppressWarnings("deprecation")
public class DomoticServer implements Observer {
	private Map<String, ICommand> comandi;
		
	public DomoticServer() {
		comandi = new HashMap<>();
	}
	
	public void addComando(ICommand o, String target) {
		comandi.put(target + "-" + o.getName(), o);
	}
	
	public void rimuoviComando(ICommand o, String target) {
		comandi.remove(target + "-" + o.getName());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Class<?> obj = (Class<?>) arg;
		Sensor<?> sensor = (Sensor<?>) o;
		reazione(sensor, obj);
	}
	
	protected <V, T extends Sensor<?>> void reazione(final T obs, Class<V> obj) {
		final String nomeTarget = List.of(obs.getClass().getName().split("\\.")).stream().reduce((first, second) -> second).orElse(null);
		System.out.println("Ottenuta notifica da " + nomeTarget);
		@SuppressWarnings("unchecked")
		V ritorno = (V) obs.getState();
		System.out.println("Lo stato è " + ritorno);
		for(ICommand comando : comandi.entrySet().stream().filter(e -> e.getKey().contains(nomeTarget)).map(e-> e.getValue()).collect(Collectors.toList())) {
			if(comando.checkExecution(obs, ritorno)) {
				comando.execute();
			} else {
				comando.turnOff();
			}
		}
	}

}
