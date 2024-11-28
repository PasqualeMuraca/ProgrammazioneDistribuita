/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import static server.Sito.*;

/**
 *
 * @author CORSO_PD
 */
@Stateless
@LocalBean
public class SitoEJB implements SitoEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void createSito(Sito s) {
        em.persist(s);
    }

    @Override
    public void modifySito(Sito s) {
        em.merge(s);
    }

    @Override
    public void deleteSito(Sito s) {
        em.remove(s);
    }

    @Override
    public List<Sito> findAll() {
        return em.createNamedQuery(FIND_ALL, Sito.class)
                .getResultList();
    }

    @Override
    public List<Sito> findByData(Date data) {
        return em.createNamedQuery(FIND_BY_DATA, Sito.class)
                .setParameter("data", data)
                .getResultList();
    }

    @Override
    public List<Sito> findByRegione(String regione) {
        return em.createNamedQuery(FIND_BY_REGIONE, Sito.class)
                .setParameter("regione", regione)
                .getResultList();
    }

    @Override
    public List<Sito> findByIntervento() {
        return em.createNamedQuery(FIND_BY_INTERVENTO, Sito.class)
                .getResultList();
    }

    @Override
    public int nidiByRegione(String regione) {
        return em.createNamedQuery(FIND_ALL)
                .getFirstResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Sito findById(int id) {
        return em.createNamedQuery(FIND_BY_ID, Sito.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
