package vaccino;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vaccino.Categoria;
import vaccino.Genere;
import vaccino.Priorita;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-12-03T20:52:04")
@StaticMetamodel(Individuo.class)
public class Individuo_ { 

    public static volatile SingularAttribute<Individuo, Categoria> cateogria;
    public static volatile SingularAttribute<Individuo, Integer> eta;
    public static volatile SingularAttribute<Individuo, Priorita> priorita;
    public static volatile SingularAttribute<Individuo, String> cognome;
    public static volatile SingularAttribute<Individuo, Integer> malattiePregresse;
    public static volatile SingularAttribute<Individuo, String> nome;
    public static volatile SingularAttribute<Individuo, Boolean> covidContratto;
    public static volatile SingularAttribute<Individuo, Integer> id;
    public static volatile SingularAttribute<Individuo, Genere> genere;
    public static volatile SingularAttribute<Individuo, Boolean> interessatoVaccino;

}