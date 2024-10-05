package poo23;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
        Materia italiano = Materia.ITALIANO;
        Materia matematica = Materia.MATEMATICA;
        Materia inglese = Materia.INGLESE;

        Scuola scuola = new Scuola();
        Classe primaA = new Classe("Prima A");
        Classe primaB = new Classe("Prima B");
        Classe secondaA = new Classe("Seconda A");
        Classe secondaB = new Classe("Seconda B");
        scuola.aggiungiClasse(primaA);
        scuola.aggiungiClasse(primaB, secondaA, secondaB);
        // System.out.println(scuola);

        Studente studente1 = new Studente("Chicca","a", 1);
        Studente studente2 = new Studente("Ciccio","a", 2);
        Studente studente3 = new Studente("Mattia","b", 3);
        primaA.aggiungiStudente(studente1, studente2, studente3);
        Studente studente4 = new Studente("b1","f", 4);
        Studente studente5 = new Studente("b2","a", 5);
        Studente studente6 = new Studente("b3","z", 6);
        primaB.aggiungiStudente(studente4, studente5, studente6);
        // Studente studente7 = new Studente("a4", 7);
        // Studente studente8 = new Studente("a5", 8);
        // Studente studente9 = new Studente("a6", 9);
        // secondaA.aggiungiStudente(studente7, studente8, studente9);
        // Studente studente10 = new Studente("b4", 10);
        // Studente student11 = new Studente("b5", 11);
        // Studente studente12 = new Studente("b6", 12);
        // secondaB.aggiungiStudente(studente10, student11, studente12);

        Docente docente1 = new Docente("d1", Materia.ITALIANO);
        Docente docente2 = new Docente("d2", Materia.INGLESE);
        Docente docente3 = new Docente("d3", Materia.MATEMATICA);
        primaA.aggiungiDocente(docente1, docente2);
        primaB.aggiungiDocente(docente1, docente3);
        secondaA.aggiungiDocente(docente2, docente3);
        secondaB.aggiungiDocente(docente1);
        docente1.aggiungiClasse(primaA, primaB, secondaB);
        docente2.aggiungiClasse(primaA, secondaA);
        docente3.aggiungiClasse(primaB, secondaA);
        // System.out.println(scuola);

        studente1.aggiungiVoto(new Voto(10, italiano), new Voto(10, inglese), new Voto(10, matematica));
        studente2.aggiungiVoto(new Voto(10, italiano), new Voto(10, inglese), new Voto(10, matematica));
        studente3.aggiungiVoto(new Voto(10, italiano), new Voto(10, inglese), new Voto(10, matematica));
        studente4.aggiungiVoto(new Voto(5, italiano), new Voto(5, inglese));
        studente5.aggiungiVoto(new Voto(1, inglese), new Voto(7, matematica));
        studente6.aggiungiVoto(new Voto(7, italiano), new Voto(7, inglese), new Voto(7, matematica));
        // System.out.println(scuola);

        long minimo3Voti = scuola.getClassi().stream()
            .flatMap(c -> c.getStudenti().stream())
            .filter(s -> s.getVoti().size() >= 3).count();
        System.out.println("Studenti che hanno minimo 3 voti: " + minimo3Voti);

        double numeroMedioClassiDocente = scuola.getClassi().stream()
            .flatMap(c -> c.getDocenti().stream())
            .mapToInt(d -> d.getClassi().size())
            .average().getAsDouble();
        System.out.println("Media dei docenti: " + numeroMedioClassiDocente);

        long studentiSufficienti = scuola.getClassi().stream()
            .flatMap(c -> c.getStudenti().stream())
            .filter(s -> s.getMedia() >= 6).count();
        System.out.println("Studenti come media sufficiente: " + studentiSufficienti);

        long numeroClassiStudentiSufficienti = scuola.getClassi().stream()
        .filter(classe -> classe.getStudenti().stream()
            .mapToDouble(Studente::getMedia)
            .filter(media -> media >= 7)
            .count() > classe.getStudenti().size() / 2)
        .count();
        System.out.println("Numero di classi con studenti con media sufficiente: " + numeroClassiStudentiSufficienti);

        List<Studente> studentiOrdinati = scuola.getClassi().stream()
            .flatMap(c -> c.getStudenti().stream())
            .sorted(
                        Comparator.comparing(Studente::getCognome)
                                .thenComparing(Studente::getNome)
            )
            .collect(Collectors.toList());
        //System.out.println("Studenti ordinati: " + studentiOrdinati);

        List<Studente> studentiOrdinatiPerMedia = scuola.getClassi().stream()
            .flatMap(c -> c.getStudenti().stream())
            .sorted(
                        Comparator.comparing(Studente::getMedia)
                                .reversed()
            ).
            collect(Collectors.toList());
        System.out.println("Studenti ordinati per media: " + studentiOrdinatiPerMedia);

    }
}
