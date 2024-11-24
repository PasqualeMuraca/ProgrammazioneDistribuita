/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import enoteca.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
/**
 *
 * @author CORSO_PD
 */
@Singleton
@LocalBean
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource40",
        name = "java:global/jdbc/EsameDS",
        user = "APP",
        password = "APP",
        databaseName = "EsameDB",
        properties = "{connectionAttributes=;create=true}"
)
public class DatabasePopulator {

    @Inject
    EnotecaEJB enotecaEJB;
    
    Vino v1, v2, v3;
    
    
    @PostConstruct
    private void populateDB() {
        v1 = new Vino(1, "Montevetrano", "Cabernet", "Colli di Salerno", 11, "Italia", 60, "Rosso", false);
        v2 = new Vino(2, "Terra di Lavoro", "Aglianico", "Galardi", 15, "Italia", 50, "Rosso", false);
        v3 = new Vino(3, "Influence Miniere", "Meunier", "Rodolphe Miniere", 5, "Francia", 40, "Champagne", true);
        enotecaEJB.createVino(v1);
        enotecaEJB.createVino(v2);
        enotecaEJB.createVino(v3);
    }
    
    @PreDestroy
    private void clearDB() {
        enotecaEJB.deleteVino(v1);
        enotecaEJB.deleteVino(v2);
        enotecaEJB.deleteVino(v3);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
