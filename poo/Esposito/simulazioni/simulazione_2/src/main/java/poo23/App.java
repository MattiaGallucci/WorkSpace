package poo23;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
        int n=0;
        double i=0.0;
        Classe classe1 = new Classe(null, null);
        List<Studente> studentiClasse1 = new ArrayList<>();
        List<Docente> docentiClasse1 = new ArrayList<>();
        List<Classe> classiDocente1 = new ArrayList<>();
        Classe classe2 = new Classe(null, null);
        List<Studente> studentiClasse2 = new ArrayList<>();
        List<Docente> docentiClasse2 = new ArrayList<>();
        List<Classe> classiDocente2 = new ArrayList<>();
        Classe classe3 = new Classe(null, null);
        List<Studente> studentiClasse3 = new ArrayList<>();
        List<Docente> docentiClasse3 = new ArrayList<>();
        List<Classe> classiDocente3 = new ArrayList<>();
        Classe classe4 = new Classe(null, null);
        List<Studente> studentiClasse4 = new ArrayList<>();
        List<Docente> docentiClasse4 = new ArrayList<>();
        List<Classe> classiDocente4 = new ArrayList<>();
        Classe classe5 = new Classe(null, null);
        List<Studente> studentiClasse5 = new ArrayList<>();
        List<Docente> docentiClasse5 = new ArrayList<>();
        List<Classe> classiDocente5 = new ArrayList<>();
        List<Docente> listaDocenti = new ArrayList<>();
        
        { // ! STUDENTI
        Voto votiGiulio = new Voto();
        votiGiulio.aggiungiVoto("Scienze", 7);
        votiGiulio.aggiungiVoto("Matematica", 4);
        votiGiulio.aggiungiVoto("Informatica", 9);
        Studente studente1 = new Studente("Giulio", "Casella", 1, votiGiulio);
        studentiClasse1.add(studente1);

        Voto votiMattia = new Voto();
        votiMattia.aggiungiVoto("Scienze", 8);
        votiMattia.aggiungiVoto("Matematica", 5);
        Studente studente2 = new Studente("Mattia", "Gallucci", 2, votiMattia);
        studentiClasse1.add(studente2);

        Voto votiCarolina = new Voto();
        votiCarolina.aggiungiVoto("Scienze", 10);
        votiCarolina.aggiungiVoto("Matematica", 10);
        votiCarolina.aggiungiVoto("Informatica", 10);
        Studente studente3 = new Studente("Carolina", "Ingino", 3, votiCarolina);
        studentiClasse1.add(studente3);
        }

        { // ! DOCENTI
        Docente docente1 = new Docente("Marco", "Polo", "Scienze", classiDocente1);
        docentiClasse1.add(docente1);
        classiDocente1.add(classe1);
        classiDocente1.add(classe2);
        classiDocente1.add(classe3);
        classiDocente1.add(classe4);
        classiDocente1.add(classe5);
        listaDocenti.add(docente1);

        Docente docente2 = new Docente("Giulio", "Casella", "Matematica", classiDocente2);
        classiDocente2.add(classe1);
        classiDocente2.add(classe2);
        listaDocenti.add(docente2);

        Docente docente3 = new Docente("Mattia", "Gallucci", "Informatica", classiDocente3);
        classiDocente3.add(classe3);
        classiDocente3.add(classe4);
        classiDocente3.add(classe5);
        listaDocenti.add(docente3);

        }
        
        classe1.aggiungi(studentiClasse1, docentiClasse1);
        
        System.out.println("Studenti con almeno 3 voti:");
        Predicate<Studente> filtro = studente -> studente.getVoti().getNumVoti() >= 3;
        List<Studente> studentiFiltrati = studentiClasse1.stream().filter(filtro).collect(Collectors.toList());
        for(Studente studente : studentiFiltrati){
            System.out.println(studente.toString());
        }

        for(Docente docente : listaDocenti){
            i += docente.classi.size();
            n++;
        }
        System.out.println("Numero medio: " + i/n);
    }
}
