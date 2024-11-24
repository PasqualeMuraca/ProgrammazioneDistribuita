/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enoteca;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author CORSO_PD
 */
@Remote
public interface EnotecaEJBRemote {
    void createVino(Vino v);
    void modifyVino(Vino v);
    void deleteVino(Vino v);

    List<Vino> findAll();
    Vino findById(int id);
    List<Vino> findByPrezzo(double p);
    List<Vino> findByVitigno(String vit);
    List<Vino> findByProvenienza(String p);
    List<Vino> findLowerThanPrezzo(double p);
}
