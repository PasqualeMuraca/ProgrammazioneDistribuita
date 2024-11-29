package babbonatale;

import static babbonatale.Bambino.*;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class BabboNataleController implements BabboNataleRemote {
    @Inject
    private EntityManager em;
    
    @Override
    public Bambino createBambino(Bambino bambino) {
        em.persist(bambino);
        return bambino;
    }

    @Override
    public void deleteBambino(Bambino bambino) {
        em.merge(bambino);
    }

    @Override
    public Bambino updateBambino(Bambino bambino) {
    
        em.remove(em.merge(bambino));
        return bambino;
    }

    @Override
    public List<Bambino> findBambiniByStato() {
        TypedQuery<Bambino> query = em.createNamedQuery(FIND_BY_REQUEST, Bambino.class);
        return query.getResultList();
        
    }

    @Override
    public List<Bambino> findBambiniByNucleo(int nucleo) {
        TypedQuery<Bambino> query = em.createNamedQuery(FIND_NUCLEO, Bambino.class);
        query.setParameter("nucleoMinimo", nucleo);
        return query.getResultList();
    }
    
    @Override
    public List<Bambino> findAllBambini() {
        TypedQuery<Bambino> query =
        em.createNamedQuery(FIND_ALL, Bambino.class);
        return query.getResultList();
    }

    @Override
    public Bambino findBambinoById(int id) {
        return em.createNamedQuery(FIND_BY_ID, Bambino.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
