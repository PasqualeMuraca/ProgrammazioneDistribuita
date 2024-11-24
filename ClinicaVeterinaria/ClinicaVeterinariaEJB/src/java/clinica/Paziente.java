/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import static clinica.Paziente.*;

/**
 *
 * @author CORSO_PD
 */
@Entity
@Table(name = "Paziente")
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "SELECT p FROM Paziente p"),
    @NamedQuery(name = FIND_BY_ID, query = "SELECT p FROM Paziente p WHERE p.id = :id"),
    @NamedQuery(name = FIND_BY_TIPO, query = "SELECT p FROM Paziente p WHERE p.tipo = :tipo"),
    @NamedQuery(name = FIND_BY_STATUS, query = "SELECT p FROM Paziente p WHERE  p.status = :status"),
    @NamedQuery(name = FIND_UNCHIPPED, query = "SELECT p FROM Paziente p WHERE  p.microchip = '0'"),
})
public class Paziente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String FIND_ALL = "Paziente.findAll";
    public static final String FIND_BY_ID = "Paziente.findById";
    public static final String FIND_BY_TIPO = "Paziente.findByTipo";
    public static final String FIND_BY_STATUS = "Paziente.findByStatus";
    public static final String FIND_UNCHIPPED = "Paziente.findUnchipped";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tipo;
    private String nome;
    private String taglia;
    private String sesso;
    private int eta;
    private String microchip;
    private boolean status;

    public Paziente(int id, String tipo, String nome, String taglia, String sesso, int eta, String microchip, boolean ricovero) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.taglia = taglia;
        this.sesso = sesso;
        this.eta = eta;
        this.microchip = microchip;
        this.status = ricovero;
    }

    public Paziente(String tipo, String nome, String taglia, String sesso, int eta, String microchip, boolean ricovero) {
        this.tipo = tipo;
        this.nome = nome;
        this.taglia = taglia;
        this.sesso = sesso;
        this.eta = eta;
        this.microchip = microchip;
        this.status = ricovero;
    }

    public Paziente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTaglia() {
        return taglia;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public boolean isRicovero() {
        return status;
    }

    public void setRicovero(boolean ricovero) {
        this.status = ricovero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.taglia);
        hash = 97 * hash + Objects.hashCode(this.sesso);
        hash = 97 * hash + this.eta;
        hash = 97 * hash + Objects.hashCode(this.microchip);
        hash = 97 * hash + (this.status ? 1 : 0);
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
        final Paziente other = (Paziente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.eta != other.eta) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.taglia, other.taglia)) {
            return false;
        }
        if (!Objects.equals(this.sesso, other.sesso)) {
            return false;
        }
        if (!Objects.equals(this.microchip, other.microchip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paziente{" + "id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", taglia=" + taglia + ", sesso=" + sesso + ", eta=" + eta + ", microchip=" + microchip + ", ricovero=" + status + '}';
    }
    
}
