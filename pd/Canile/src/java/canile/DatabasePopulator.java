/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canile;

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
    name = "java:global/jdbc/CanileDS",
    user = "APP",
    password = "APP",
    databaseName = "CanileDB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    CanileEJB ejb;
    Cane c1, c2, c3;
    
    @PostConstruct
    private void populateDB(){
        c1 = new Cane(
                "Labrador", 
                "Buddy", 
                Taglia.GRANDE, 
                Sesso.MASCHIO, 
                FasciaEta.TRE_SETTE, 
                123456789, 
                false);
        c2 = new Cane(
                "Beagle", 
                "Bella", 
                Taglia.MEDIA, 
                Sesso.FEMMINA, 
                FasciaEta.ZERO_DUE, 
                987654321, 
                true);
        c3 = new Cane("Carlino", 
                "Max", 
                Taglia.PICCOLA, 
                Sesso.MASCHIO, 
                FasciaEta.OTTO_PIU, 
                456789123, 
                false);

        ejb.creaCane(c1);
        ejb.creaCane(c2);
        ejb.creaCane(c3);
    }
    
    @PreDestroy
    private void clearDB(){
        ejb.eliminaCane(c1);
        ejb.eliminaCane(c2);
        ejb.eliminaCane(c3);
    }
}
