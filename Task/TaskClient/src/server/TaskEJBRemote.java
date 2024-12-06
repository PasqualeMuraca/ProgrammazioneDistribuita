/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CORSO_PD
 */
@Remote
public interface TaskEJBRemote {
    void createTask(Task t);
    void modifyTask(Task t);
    void deleteTask(Task t);
    
    Task findById(int id);
    List<Task> findAll();
    List<Task> findByTipo(String tipo);
    List<Task> findByOre(int ore);
    List<Task> findByAssegnatario(String assegnatario);
    List<Task> findByOreLessThan(int ore);
    List<Task> findByNonCompletati();
}
