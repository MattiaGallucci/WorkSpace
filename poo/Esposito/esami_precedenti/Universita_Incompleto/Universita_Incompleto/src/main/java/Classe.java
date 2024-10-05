import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Classe {
	private String materia;
	private List<Studente> partecipanti;
	private List<Docente> docenti;
	private List<Dottorando> tutor;
	private Map<Studente, Integer> votazioni;
	
	public Classe(String materia, Docente... docs) {
		this.materia = materia;
		docenti = Arrays.asList(docs);
		partecipanti = new ArrayList<>();
		tutor = new ArrayList<>();
		votazioni = new HashMap<>();
	}
	
	public static Classe create(String str) {
		StringTokenizer st = new StringTokenizer(str,",");    
	    if(st.countTokens() != 1)
	    	throw new IllegalArgumentException("I need only one token");
	    else
			return new Classe(st.nextToken()); 
	}

	public String getMateria() {
		return materia;
	}

	public List<Studente> getPartecipanti() {
		return partecipanti;
	}

	public List<Docente> getDocenti() {
		return docenti;
	}

	public List<Dottorando> getTutor() {
		return tutor;
	}
	
	public List<Entry<Studente,Integer>> getVotazioni() {
		return List.copyOf(votazioni.entrySet());
	}
	
	public void add(Studente... studenti) {
		partecipanti.addAll(Arrays.asList(studenti));
	}
	
	public void add(Docente... docenti) {
		this.docenti.addAll(Arrays.asList(docenti));
	}
	
	public void add(Dottorando... dottorandi) {
		tutor.addAll(Arrays.asList(dottorandi));
	}
	
	public void addVoti(@SuppressWarnings("unchecked") Entry<String,Integer>... entries) {
		/*for(Entry<String,Integer> e : entries) 
			for(Studente stu : partecipanti) {
				if(stu.getMatricola().equals(e.getKey()))
					votazioni.put(stu, e.getValue());
			}*/
		
		//Meglio
		Arrays.stream(entries).forEach(e -> votazioni.put(partecipanti.stream()
				.filter(s -> s.getMatricola().equals(e.getKey()))
				.findAny().orElse(null), e.getValue()));
	}
}