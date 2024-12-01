package uefa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uefa.TipologiaPartita;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-11-27T14:26:39")
@StaticMetamodel(Partita.class)
public class Partita_ { 

    public static volatile SingularAttribute<Partita, Boolean> giocata;
    public static volatile SingularAttribute<Partita, String> squadraOspite;
    public static volatile SingularAttribute<Partita, Integer> goalSquadraCasa;
    public static volatile SingularAttribute<Partita, Integer> goalSquadraOspite;
    public static volatile SingularAttribute<Partita, TipologiaPartita> tipologiaPartita;
    public static volatile SingularAttribute<Partita, Integer> numeroAmmonizioni;
    public static volatile SingularAttribute<Partita, Integer> numeroEspulsioni;
    public static volatile SingularAttribute<Partita, Integer> id;
    public static volatile SingularAttribute<Partita, String> squadraCasa;

}