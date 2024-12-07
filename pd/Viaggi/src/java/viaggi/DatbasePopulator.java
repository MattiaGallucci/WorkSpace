/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viaggi;

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
    name = "java:global/jdbc/ViaggiDS",
    user = "APP",
    password = "APP",
    databaseName = "ViaggiDB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatbasePopulator {
    @Inject
    ViaggioEJB ejb;
    
    Viaggio v1, v2, v3;
    
    @PostConstruct
    private void populateDB(){
        v1 = new Viaggio(1, "Mare", "Seychelles", 500, 10, 10);
        v2 = new Viaggio(2, "Mare", "Corfù", 200, 0, 20);
        v3 = new Viaggio(3, "Montagna", "Cortina", 700, 20, 30);
    
        ejb.crea(v1);
        ejb.crea(v2);
        ejb.crea(v3);
    }
    
    @PreDestroy
    private  void clearDB(){
        ejb.elimina(v1);
        ejb.elimina(v2);
        ejb.elimina(v3);
    }
}
