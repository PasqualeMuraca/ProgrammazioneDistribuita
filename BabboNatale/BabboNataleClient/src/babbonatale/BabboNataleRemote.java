package babbonatale;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface BabboNataleRemote {
    Bambino createBambino(Bambino bambino);
    void deleteBambino(Bambino bambino);
    Bambino updateBambino(Bambino bambino);
    Bambino findBambinoById(int id);
    List<Bambino> findBambiniByStato();
    List<Bambino> findBambiniByNucleo(int nucleo);
    List<Bambino> findAllBambini();
}