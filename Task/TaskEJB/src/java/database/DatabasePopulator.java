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
import server.*;

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
    private TaskEJB ejb;
    private Task t1, t2, t3;

    @PostConstruct
    private void populateDB() {
        t1 = new Task(1, "Completare pagina home del sito web", "comunicazione", 4, "Maria", 0);
        t2 = new Task(2, "Presentazione novità", "innovazione", 2, "nessuno", 75);
        t3 = new Task(3, "Emettere fattura cliente 2", "amministrazione", 7, "Pasquale", 100);

        ejb.createTask(t1);
        ejb.createTask(t2);
        ejb.createTask(t3);
    }
    
    @PreDestroy
    private void clearDB() {
        ejb.deleteTask(t1);
        ejb.deleteTask(t2);
        ejb.deleteTask(t3);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
