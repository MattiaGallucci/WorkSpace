import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniApp {
	private List<Studente> studenti;
	private List<Docente> docenti;
	private List<Dottorando> dottorandi;
	private List<Classe> classi;
	
	public UniApp() {
		studenti = new ArrayList<>();
		docenti = new ArrayList<>();
		dottorandi = new ArrayList<>();
		classi = new ArrayList<>();
	}
	
	public void inserisciStudente() {
		/*Path path = Paths.get("target/studenti.txt");
		System.out.println(path.toAbsolutePath());
		List<String> lines = new ArrayList<>();
	    /* Implementazione imperativa
	     * try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){       
	      String currentLine = null;
	      while((currentLine = reader.readLine()) != null){//while there is content on the current line
	        lines.add(currentLine); 
	      }
	    }catch(IOException ex){
	      ex.printStackTrace(); //handle an exception here
	    }*/
		/*try {
			Files.lines(path).forEach(lines::add);
		} catch (IOException ex) {
		  ex.printStackTrace();
		}
		studenti.addAll(lines.stream().map().collect(Collectors.toList()));*/
		studenti.addAll(getListFromFile("target/studenti.txt", Studente::create));
	}
	
	private <T> List<T> getListFromFile(String nomeFile, Function<String, T> mapper) {
		Path path = Paths.get(nomeFile);
		System.out.println(path.toAbsolutePath());
		List<String> lines = new ArrayList<>();
	    try {
			Files.lines(path).forEach(lines::add);
		} catch (IOException ex) {
		  ex.printStackTrace();
		}
		return lines.stream().map(mapper).collect(Collectors.toList());
	}
	
	public void inserisciDocente() {
		/*Path path = Paths.get("target/docenti.txt");
		List<String> lines = new ArrayList<>();
		try {
			Files.lines(path).forEach(lines::add);
		} catch (IOException ex) {
		  ex.printStackTrace();
		}
		docenti.addAll(lines.stream().map(Docente::create).collect(Collectors.toList()));*/
		docenti.addAll(getListFromFile("target/docenti.txt", Docente::create));
	}
	
	public void inserisciDottorando() {
		/*Path path = Paths.get("target/dottorandi.txt");
		List<String> lines = new ArrayList<>();
		try {
			Files.lines(path).forEach(lines::add);
		} catch (IOException ex) {
		  ex.printStackTrace();
		}
		dottorandi.addAll(lines.stream().map(Dottorando::create).collect(Collectors.toList()));*/
		dottorandi.addAll(getListFromFile("target/dottorandi.txt", Dottorando::create));
	}
	
	public void creaClasse() {
		/*Path path = Paths.get("target/classi.txt");
		List<String> lines = new ArrayList<>();
		try {
			Files.lines(path).forEach(lines::add);
		} catch (IOException ex) {
		  ex.printStackTrace();
		}
		classi.addAll(lines.stream().map(Classe::create).collect(Collectors.toList()));*/
		classi.addAll(getListFromFile("target/classi.txt", Classe::create));
	}
	
	public void displayStudenti() {
		studenti.stream().forEach(System.out::println);
	}
	public void displayDocenti() {
		docenti.stream().forEach(System.out::println);
	}
	public void displayDottorandi() {
		dottorandi.stream().forEach(System.out::println);
	}
	
	private <T> boolean copia(List<? extends T> src, List<? super T> dest, Predicate<T> pred) {
		Optional<List<T>> oplist = Optional.ofNullable(src.stream().filter(pred).collect(Collectors.toList()));
		oplist.ifPresent(dest::addAll);
		return oplist.isPresent();
	}
	
	public void displayStudentiPromossi() {
		try (Scanner keyboard = new Scanner(System.in);) {
			System.out.println("Insert materia: ");
			final String classe = keyboard.next();
			List<Entry<Studente,Integer>> src = classi.stream().filter(c -> c.getMateria().equals(classe))
						   						.flatMap(c -> c.getVotazioni().stream()).collect(Collectors.toList());
		    src.stream().filter(e -> e.getValue() >= 18)
		       .map(e -> e.getKey().getNome() + " " + e.getKey().getCognome()).forEach(System.out::println);
		    List <Studente> newSrc = src.stream().filter(e -> e.getValue() >= 18)
		       .map(Entry::getKey).collect(Collectors.toList());
		    List <Studente> dest = new ArrayList<>();
		    copia(newSrc, dest, s -> s.getMatricola().contains("AA"));
		    dest.stream().forEach(System.out::println);
		}
	}
	
	public static void main(String[] args) {
		
		
		UniApp uni = new UniApp();
		Runnable[] methods = {
			uni::inserisciStudente,
			uni::inserisciDocente,
			uni::inserisciDottorando,
			uni::creaClasse,
			uni::displayStudenti,
			uni::displayDocenti,
			uni::displayDottorandi,
			uni::displayStudentiPromossi
		};
		
		int scelta = -1;
		try (Scanner keyboard = new Scanner(System.in);) {		
			do {
				System.out.println("Make a choise");
				System.out.println("1  - Insert Student");
				System.out.println("2  - Insert Teacher");
				System.out.println("3  - Insert PhD student");
				System.out.println("4  - Create Class");
				System.out.println("5  - Display Students");
				System.out.println("6  - Dispaly Teachers");
				System.out.println("7  - Display PhD students");
				System.out.println("8  - Display Passed students");
				System.out.println("-1 - To exit");
				scelta = keyboard.nextInt();
				if(scelta > 0)
					methods[scelta-1].run();
			} while(scelta != -1);
		}
	}

}
