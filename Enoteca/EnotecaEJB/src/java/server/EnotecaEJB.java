/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.*;
import javax.persistence.*;

import static server.Vino.*;
import javax.ejb.LocalBean;

/**
 *
 * @author CORSO_PD
 */
@Stateless
@LocalBean
public class EnotecaEJB implements EnotecaEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void createVino(Vino v) {
        em.persist(v);
    }

    @Override
    public void modifyVino(Vino v) {
        em.merge(v);
    }

    @Override
    public void deleteVino(Vino v) {
        em.remove(v);
    }

    @Override
    public List<Vino> findAll() {
        return em.createNamedQuery(FIND_ALL, Vino.class)
                .getResultList();
    }

    @Override
    public Vino findById(int id) {
        return em.createNamedQuery(FIND_BY_ID, Vino.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Vino> findByPrezzo(double p) {
        return em.createNamedQuery(FIND_BY_PREZZO, Vino.class)
                .setParameter("prezzo", p)
                .getResultList();
    }

    @Override
    public List<Vino> findByVitigno(String vit) {
        return em.createNamedQuery(FIND_BY_VITIGNO, Vino.class)
                .setParameter("vitigno", vit)
                .getResultList();
    }

    @Override
    public List<Vino> findByProvenienza(String p) {
        return em.createNamedQuery(FIND_BY_PROVENIENZA, Vino.class)
                .setParameter("provenienza", p)
                .getResultList();
    }

    @Override
    public List<Vino> findLowerThanPrezzo(double p) {
        return em.createNamedQuery(FIND_LOWER_THAN_PREZZO, Vino.class)
                .setParameter("limiteSup", p)
                .getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
