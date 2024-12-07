/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpcm;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.dery.jdc.EmbeddedDataSoure",
        name = "java:global/jdbc/DpcmDS",
        user = "APP",
        password = "APP",
        databaseName = "DpcmDB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator{
    @Inject
    DpcmEJB ejb;
	
    Dpcm d1, d2, d3;

    @PostConstruct
    private void populateDB(){
        d1 = new Dpcm(1, "Decreto CoronaVirus", "Covid", "Sanitaria", "1", 12);
        d2 = new Dpcm(2, "E’ arrivata la fine del mondo", "Diluvio", "Fine del mondo", "1", 1);
        d3 = new Dpcm(3, "La Peste Nera è qui", "Peste", "Sanitaria", "2", 8);

        ejb.crea(d1);
        ejb.crea(d2);
        ejb.crea(d3);
    }

    @PreDestroy
    private void clearDB(){
        ejb.elimina(d1);
        ejb.elimina(d2);
        ejb.elimina(d3);
    }
}
