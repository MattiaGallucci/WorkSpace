/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uefa;

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
    name = "java:global/jdbc/UEFADS",
    user = "APP",
    password = "APP",
    databaseName = "UEFADB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    Partita p1, p2, p3;
    @Inject
    PartitaEJB ejb;
    
    @PostConstruct
    private void populateDB(){
        p1 = new Partita(
            TipologiaPartita.GIRONE1,
            "Juventus",
            "Real Madrid",
            2,
            1,
            3,
            0,
            true
        );
        
        p2 = new Partita(
            TipologiaPartita.OTTAVI,
            "Barcellona",
            "Manchester City",
            3,
            4,
            2,
            1,
            true
        );
        
        p3 = new Partita(
            TipologiaPartita.FINALE,
            "Italia",
            "Francia",
            10,
            0,
            4,
            2,
            true
        );
        
        ejb.creaPartita(p1);
        ejb.creaPartita(p2);
        ejb.creaPartita(p3);
    }
    
    @PreDestroy
    private void clearDB(){
        ejb.eliminaPartita(p1);
        ejb.eliminaPartita(p2);
        ejb.eliminaPartita(p3);
    }
}
