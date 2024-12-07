/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino;

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
    name = "java:global/jdbc/VaccinoDS",
    user = "APP",
    password = "APP",
    databaseName = "VaccinoDB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    VaccinoEJB ejb;
    Individuo i1, i2;
    
    @PostConstruct
    public void populateDB(){
        i1 = new Individuo("n1", "c1", Categoria.DOCENTE, 25, Genere.M, 0, true, true, Priorita.ALTA);
        i2 = new Individuo("n2", "c2", Categoria.PENSIONATO, 25, Genere.M, 0, true, true, Priorita.ALTA);
    
        ejb.creaIndividuo(i1);
        ejb.creaIndividuo(i2);
    }
    
    @PreDestroy
    public void clearDB(){
        ejb.eliminaIndividuo(i1);
        ejb.eliminaIndividuo(i2);
    }
}
