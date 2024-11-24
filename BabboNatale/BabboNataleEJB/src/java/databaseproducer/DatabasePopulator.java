package databaseproducer;

import babbonatale.BabboNataleController;
import babbonatale.Bambino;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
className ="org.apache.derby.jdbc.EmbeddedDataSource40",
    name ="java:global/jdbc/EsameDS",
    user ="APP",
    password ="APP",
    databaseName ="EsameDB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject 
    BabboNataleController babboNataleController;
    private Bambino b1, b2, b3;
    
    @PostConstruct
    private void populateDB(){
        b1 = new Bambino("Di Dio Angelo", "Messina", "Italia", 4, 3, true, "NO");
        b2 = new Bambino("God Angeline", "New York", "USA", 3, 10, false, "NO");
        b3 = new Bambino("Birbantello Luigi", "Salerno", "Italia", 5, 3, false, "SI");
        babboNataleController.createBambino(b1);
        babboNataleController.createBambino(b2);
        babboNataleController.createBambino(b3);
    }
    
    @PreDestroy
    private void clearDB(){
        babboNataleController.deleteBambino(b1);
        babboNataleController.deleteBambino(b2);
        babboNataleController.deleteBambino(b3);
    }
}