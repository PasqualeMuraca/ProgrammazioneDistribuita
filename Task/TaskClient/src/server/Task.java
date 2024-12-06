/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import static server.Task.*;

/**
 *
 * @author CORSO_PD
 */
@Entity
@Table(name = "Task")
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "SELECT t FROM Task t"),
    @NamedQuery(name = FIND_BY_ID, query = "SELECT t FROM Task t WHERE t.id = :id"),
    @NamedQuery(name = FIND_BY_TIPO, query = "SELECT t FROM Task t WHERE t.tipo = :tipo"),
    @NamedQuery(name = FIND_BY_ORE, query = "SELECT t FROM Task t WHERE t.orePreviste = :ore"),
    @NamedQuery(name = FIND_BY_ASSEGNATARIO, query = "SELECT t FROM Task t WHERE t.assegnatario = :assegnatario"),
    @NamedQuery(name = FIND_BY_ORE_LESS_THAN, query = "SELECT t FROM Task t WHERE t.orePreviste < :ore"),
    @NamedQuery(name = FIND_BY_NON_COMPLETATI, query = "SELECT t FROM Task t WHERE t.percentuale < 100"),
})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String FIND_ALL = "Task.findAll";
    public static final String FIND_BY_ID = "Task.findById";
    public static final String FIND_BY_TIPO = "Task.findByTipo";
    public static final String FIND_BY_ORE = "Task.findByOre";
    public static final String FIND_BY_ASSEGNATARIO = "Task.findByAssegnatario";
    public static final String FIND_BY_ORE_LESS_THAN = "Task.findByOreLessThan";
    public static final String FIND_BY_NON_COMPLETATI = "Task.findByNonCompletati";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String tipo;
    @Min(1) @Max(8)
    private int orePreviste;
    private String assegnatario;
    @Min(0) @Max(100)
    private int percentuale;

    public Task() {
    }
    
    public Task(int id, String nome, String tipo, int orePreviste, String assegnatario, int percentuale) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.orePreviste = orePreviste;
        this.assegnatario = assegnatario;
        this.percentuale = percentuale;
    }

    public Task(String nome, String tipo, int orePreviste, String assegnatario, int percentuale) {
        this.nome = nome;
        this.tipo = tipo;
        this.orePreviste = orePreviste;
        this.assegnatario = assegnatario;
        this.percentuale = percentuale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getOrePreviste() {
        return orePreviste;
    }

    public void setOrePreviste(int orePreviste) {
        this.orePreviste = orePreviste;
    }

    public String getAssegnatario() {
        return assegnatario;
    }

    public void setAssegnatario(String assegnatario) {
        this.assegnatario = assegnatario;
    }

    public int getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(int percentuale) {
        this.percentuale = percentuale;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.tipo);
        hash = 29 * hash + this.orePreviste;
        hash = 29 * hash + Objects.hashCode(this.assegnatario);
        hash = 29 * hash + this.percentuale;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.orePreviste != other.orePreviste) {
            return false;
        }
        if (this.percentuale != other.percentuale) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.assegnatario, other.assegnatario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", orePreviste=" + orePreviste + ", assegnatario=" + assegnatario + ", percentuale=" + percentuale + '}';
    }
    
}
