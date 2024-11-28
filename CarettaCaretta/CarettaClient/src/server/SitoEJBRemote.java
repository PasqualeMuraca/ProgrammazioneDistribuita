/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CORSO_PD
 */
@Remote
public interface SitoEJBRemote {
    void createSito(Sito s);
    void modifySito(Sito s);
    void deleteSito(Sito s);
    
    List<Sito> findAll();
    Sito findById(int id);
    List<Sito> findByData(Date data);
    List<Sito> findByRegione(String regione);
    List<Sito> findByIntervento();
    int nidiByRegione(String regione);
}
