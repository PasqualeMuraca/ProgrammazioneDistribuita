/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import static server.Task.*;

/**
 *
 * @author CORSO_PD
 */
@Stateless
@LocalBean
public class TaskEJB implements TaskEJBRemote {

    @Inject
    private EntityManager em;
    
    @Override
    public void createTask(Task t) {
        em.persist(t);
    }

    @Override
    public void modifyTask(Task t) {
        em.merge(t);
    }

    @Override
    public void deleteTask(Task t) {
        em.remove(t);
    }

    @Override
    public Task findById(int id) {
        return em.createNamedQuery(FIND_BY_ID, Task.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Interceptors(TaskInterceptor.class)
    public List<Task> findAll() {
        return em.createNamedQuery(FIND_ALL, Task.class)
                .getResultList();
    }

    @Override
    public List<Task> findByTipo(String tipo) {
        return em.createNamedQuery(FIND_BY_TIPO, Task.class)
                .setParameter("tipo", tipo)
                .getResultList();
    }

    @Override
    public List<Task> findByOre(int ore) {
        return em.createNamedQuery(FIND_BY_ORE, Task.class)
                .setParameter("ore", ore)
                .getResultList();
    }

    @Override
    public List<Task> findByAssegnatario(String assegnatario) {
        return em.createNamedQuery(FIND_BY_ASSEGNATARIO, Task.class)
                .setParameter("assegnatario", assegnatario)
                .getResultList();
    }

    @Override
    public List<Task> findByOreLessThan(int ore) {
        return em.createNamedQuery(FIND_BY_ORE_LESS_THAN, Task.class)
                .setParameter("ore", ore)
                .getResultList();
    }

    @Override
    public List<Task> findByNonCompletati() {
        return em.createNamedQuery(FIND_BY_NON_COMPLETATI, Task.class)
                .getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
