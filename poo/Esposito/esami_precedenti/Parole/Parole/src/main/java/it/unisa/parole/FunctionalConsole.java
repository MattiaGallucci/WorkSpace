package it.unisa.parole;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalConsole {
	private List<String> strings;
	public FunctionalConsole(Supplier<List<String> > supplier) {
		strings = supplier.get();
	}
	
	public void consume(Consumer< List<String> > consumer) {
		consumer.accept(strings);
	}
	
	public <T> T process(Function<List<String>, T> func) {
		return func.apply(strings);
	}
}
