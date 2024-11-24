/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import static clinica.Paziente.*;
import javax.ejb.LocalBean;

/**
 *
 * @author CORSO_PD
 */
@Stateless
@LocalBean
public class ClinicaEJB implements ClinicaEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void createPaziente(Paziente p) {
        em.persist(p);
    }

    @Override
    public void updatePaziente(Paziente p) {
        em.merge(p);
    }

    @Override
    public void deletePaziente(Paziente p) {
        em.remove(p);
    }

    @Override
    public List<Paziente> findAll() {
        return em.createNamedQuery(FIND_ALL, Paziente.class)
                .getResultList();
    }

    @Override
    public List<Paziente> findById(int id) {
        return em.createNamedQuery(FIND_BY_ID, Paziente.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Paziente> findByTipo(String tipo) {
        return em.createNamedQuery(FIND_BY_TIPO, Paziente.class)
                .setParameter("tipo", tipo)
                .getResultList();
    }

    @Override
    public List<Paziente> findByStatus(boolean status) {
        return em.createNamedQuery(FIND_BY_STATUS, Paziente.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<Paziente> findUnchipped() {
        return em.createNamedQuery(FIND_UNCHIPPED, Paziente.class)
                .getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
