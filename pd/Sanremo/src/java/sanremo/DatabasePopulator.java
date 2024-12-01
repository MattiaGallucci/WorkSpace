/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

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
    name = "java:global/jdbc/SanremoDS",
    user = "APP",
    password = "APP",
    databaseName = "SanremoDB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject SanremoEJB ejb;
    Canzone c1, c2, c3;
    
    @PostConstruct
    private void populateDB(){
        c1 = new Canzone("Diodato", "Pop", "Sai che cosa penso", false, 1000);
        c2 = new Canzone("Piero", "Rock", "Spingi forte", false, 13);
        c3 = new Canzone("Bugo e Morgan", "Pop", "Le buone intenzioni", false, 5000);
        
        ejb.crea(c1);
        ejb.crea(c2);
        ejb.crea(c3);
    }
    
    @PreDestroy
    private void clearDB(){
        ejb.elimina(c1);
        ejb.elimina(c2);
        ejb.elimina(c3);
    }
}
