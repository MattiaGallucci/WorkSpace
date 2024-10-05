package it.unisa.parole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {

	public static void main(String[] args) throws IOException {
		// Implementazione adottando i Design Pattern Strategy, Iterator e Template Method		
		Strategy s1 = new FileStrategy("prova.txt");
		Contatore<Character> cont1 = new ContatoreMinuscole();
		Console c1 = new Console(s1, cont1);
		for(int i = 0; i < 3; i++) {
			c1.chiediStringa();
		}
		
		Strategy s2 = new VideoStrategy();
		Contatore<String> cont2 = new ContatoreParole();
		Console c2 = new Console(s2, cont2);
		for(int i = 0; i < 3; i++) {
			c2.chiediStringa();
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Inserire una parola da cercare: ");
		String word = reader.readLine();
		Strategy s3 = new StringBufferStrategy();
		Contatore<String> cont3 = new ContatoreSpecificaParola(word);
		Console c3 = new Console(s3, cont3);
		for(int i = 0; i < 3; i++) {
			c3.chiediStringa();
		}
		reader.close();
		
		//Implementazione con stream
		Path path = Paths.get("prova.txt");
        try (Stream<String> lines = Files.lines(path)) {
        	FunctionalConsole Fconsole = new FunctionalConsole(() -> lines.collect(Collectors.toList()));
        	Fconsole.consume(strings -> strings.stream().forEach(System.out::println));
        	System.out.println("Conteggio Lettere Maniuscole nelle linee precedenti: " +
        			Fconsole.process(strings -> strings.stream().flatMap(s -> s.chars().mapToObj(e->(char)e).collect(Collectors.toList()).stream()).filter(c -> Character.isUpperCase(c)).count()));
            System.out.println("Conteggio Lettere Minuscole nelle linee precedenti: " +
            		Fconsole.process(strings -> strings.stream().mapToLong(s -> s.chars().mapToObj(e->(char)e).collect(Collectors.toList()).stream().filter(c -> Character.isLowerCase(c)).count()).sum()));
            
            System.out.println("Conteggio delle occorrenze di casa nelle linee precedenti: " +
            		Fconsole.process(strings -> strings.stream().flatMap(s -> Arrays.asList(s.split("\\P{L}+")).stream()).filter(s -> s.contains("casa")).count()));

        } catch (IOException ex) {
          ex.printStackTrace();
        }
	}

}
