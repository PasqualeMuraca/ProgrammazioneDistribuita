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

import clinica.*;
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
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

    @Inject
    ClinicaEJB clinicaEJB;
    
    private Paziente p1, p2, p3;
    
    
    @PostConstruct
    private void populateDB() {
        p1 = new Paziente(1, "Cane", "Leo", "Media", "M", 1, "0", false);
        p2 = new Paziente(2, "Gatto", "Micio", "Piccola", "F", 3, "941000001581506", false);
        p3 = new Paziente(3, "Coniglio", "Michelle", "Piccola", "F", 1, "981100000297746", true);
        
        clinicaEJB.createPaziente(p1);
        clinicaEJB.createPaziente(p2);
        clinicaEJB.createPaziente(p3);
    }
    
    @PreDestroy
    private void clearDB() {
        clinicaEJB.deletePaziente(p1);
        clinicaEJB.deletePaziente(p2);
        clinicaEJB.deletePaziente(p3);
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
