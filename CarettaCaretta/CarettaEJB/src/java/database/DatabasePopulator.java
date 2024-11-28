/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;
import server.Sito;
import server.SitoEJB;

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
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

    @Inject
    private SitoEJB sitoEJB;
    private Sito s1, s2, s3;

    @PostConstruct
    private void populateDB() {
        s1 = new Sito(1, new Date(2021, 7, 15), "Campania", "Ascea", 1, 20, true, true);
        s2 = new Sito(2, new Date(2021, 6, 20), "Sicilia", "Isola dei Conigli", 10, 600, false, false);
        s3 = new Sito(3, new Date(2013, 6, 20), "Sicilia", "Giallonardo", 2, 169, true, false);
        sitoEJB.createSito(s1);
        sitoEJB.createSito(s2);
        sitoEJB.createSito(s3);
    }
    
    @PreDestroy
    private void clearDB() {
        sitoEJB.deleteSito(s1);
        sitoEJB.deleteSito(s2);
        sitoEJB.deleteSito(s3);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
