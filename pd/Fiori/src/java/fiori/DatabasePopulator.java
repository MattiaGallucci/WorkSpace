/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiori;

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
    name = "java:global/jdbc/FioriDS",
    user = "APP",
    password = "APP",
    databaseName = "FioriDB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    FioriEJB ejb;
    
    Fiore f1, f2, f3;
    
    @PostConstruct
    private void populateDB(){
        f1 = new Fiore(1, "Petunia", "xxx", "Annuale", "xxx", "Antiossidante", "xxx", "xxx", "Dolci", 12);
        f2 = new Fiore(2, "Calendula", "xxx", "Perenne", "xxx", "Antinfiammatorie", "xxx", "xxx", "Infusi", 34);
        f3 = new Fiore(3, "Viola del pensiero", "xxx", "Annuale", "xxx", "Antinfiammatorie", "xxx", "xxx", "Insalate", 15);
    
        ejb.crea(f1);
        ejb.crea(f2);
        ejb.crea(f3);
    }
    
    @PreDestroy
    private void clearDB(){
        ejb.elimina(f1);
        ejb.elimina(f2);
        ejb.elimina(f3);
    }
}
