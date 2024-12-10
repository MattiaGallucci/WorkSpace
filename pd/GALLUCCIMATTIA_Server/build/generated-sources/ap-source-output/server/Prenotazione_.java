package server;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-12-10T08:54:43")
@StaticMetamodel(Prenotazione.class)
public class Prenotazione_ { 

    public static volatile SingularAttribute<Prenotazione, LocalDateTime> dataTempo;
    public static volatile SingularAttribute<Prenotazione, String> tipoTavolo;
    public static volatile SingularAttribute<Prenotazione, Integer> id;
    public static volatile SingularAttribute<Prenotazione, String> nomeCliente;
    public static volatile SingularAttribute<Prenotazione, Integer> numeroPersone;

}