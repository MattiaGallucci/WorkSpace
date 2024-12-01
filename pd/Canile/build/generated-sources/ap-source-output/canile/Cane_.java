package canile;

import canile.FasciaEta;
import canile.Sesso;
import canile.Taglia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-12-01T14:50:12")
@StaticMetamodel(Cane.class)
public class Cane_ { 

    public static volatile SingularAttribute<Cane, Taglia> taglia;
    public static volatile SingularAttribute<Cane, Boolean> adottato;
    public static volatile SingularAttribute<Cane, String> razza;
    public static volatile SingularAttribute<Cane, FasciaEta> fasciaEta;
    public static volatile SingularAttribute<Cane, Sesso> sesso;
    public static volatile SingularAttribute<Cane, String> nome;
    public static volatile SingularAttribute<Cane, Integer> microchip;
    public static volatile SingularAttribute<Cane, Integer> id;

}