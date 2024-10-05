package poo23;

import java.util.List;

public class Main 
{
    public static void main( String[] args )
    {
        Classe classe1 = new Classe("1A");
        Materia matematica = new Materia("Matematica");
        Materia informatica = new Materia("Informatica");
        //Materia inglese = new Materia("Inglese");
        Studente studente1 = new Studente("Mattia", "Gallucci", "1", classe1);
        Studente studente2 = new Studente("Carolina", "Ingino", "2", classe1);
        Studente studente3 = new Studente("Giulio", "Rossi", "3", classe1);
        //Docente docente1 = new Docente("Mario", "Rossi", "1" ,List.of(matematica, informatica));
        //Docente docente2 = new Docente("Giulio", "Verdi", "2", List.of(informatica, inglese));

        matematica.aggiungiVoti(studente1, List.of(6, 7, 2, 3, 10));
        informatica.aggiungiVoti(studente2, List.of(8, 9, 10, 10, 10));
        informatica.aggiungiVoti(studente3, List.of(10, 10, 10, 10, 10));
        classe1.setStudenti(List.of(studente1, studente2, studente3));

        //System.out.println("Matematica: " + matematica.mediaVoti(studente1) + matematica.mediaVoti(studente2) + matematica.mediaVoti(studente3));
        double media = matematica.getVoti(studente1).stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("Media: " + media);
    }
}
