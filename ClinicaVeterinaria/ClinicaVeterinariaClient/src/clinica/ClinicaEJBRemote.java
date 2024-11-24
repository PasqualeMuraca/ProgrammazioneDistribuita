/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CORSO_PD
 */
@Remote
public interface ClinicaEJBRemote {
    void createPaziente(Paziente p);
    void updatePaziente(Paziente p);
    void deletePaziente(Paziente p);
    
    List<Paziente> findAll();
    List<Paziente> findById(int id);
    List<Paziente> findByTipo(String tipo);
    List<Paziente> findByStatus(boolean status);
    List<Paziente> findUnchipped();
}
