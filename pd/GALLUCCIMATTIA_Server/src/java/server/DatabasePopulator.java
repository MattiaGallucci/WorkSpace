package server;

import java.time.LocalDateTime;
import java.time.Month;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/EsameDS",
        user = "APP",
        password = "APP",
        databaseName = "EsameDB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private RistoranteEJB ejb;
    
    private Prenotazione p1, p2, p3, p4, p5;

    @PostConstruct
    private void populateDB() {
        p1 = new Prenotazione(1, "mario rossi", 9, "VIP", LocalDateTime.of(2024, 12, 6, 17, 45));
        p2 = new Prenotazione(2, "luigi bruno", 2, "Generico", LocalDateTime.of(2024, 2, 14, 21, 30));
        p3 = new Prenotazione(3, "marco bianchi", 5, "Famiglia", LocalDateTime.of(2024, 6, 20, 20, 04));
        p4 = new Prenotazione(4, "chicca rosa", 2, "VIP", LocalDateTime.of(2024, 4, 20, 20, 23));
        p5 = new Prenotazione(5, "francesco verdi", 15, "Generico", LocalDateTime.of(2024, 9, 3, 20, 03));
        
        ejb.crea(p1);
        ejb.crea(p2);
        ejb.crea(p3);
        ejb.crea(p4);
        ejb.crea(p5);
    }

    @PreDestroy
    private void clearDB() {
        ejb.elimina(p1);
        ejb.elimina(p2);
        ejb.elimina(p3);
        ejb.elimina(p4);
        ejb.elimina(p5);
    }
}