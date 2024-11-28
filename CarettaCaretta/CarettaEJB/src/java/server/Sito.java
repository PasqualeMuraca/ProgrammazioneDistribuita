/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import static server.Sito.*;


/**
 *
 * @author CORSO_PD
 */
@Entity
@Table(name = "Sito")
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "SELECT s FROM Sito s"),
    @NamedQuery(name = FIND_BY_ID, query = "SELECT s FROM Sito s WHERE s.id = :id"),
    @NamedQuery(name = FIND_BY_DATA, query = "SELECT s FROM Sito s WHERE s.data = :data"),
    @NamedQuery(name = FIND_BY_REGIONE, query = "SELECT s FROM Sito s WHERE s.regione = :regione"),
    @NamedQuery(name = FIND_BY_INTERVENTO, query = "SELECT s FROM Sito s WHERE s.intervento = true"),
    @NamedQuery(name = NIDI_BY_REGIONE, query = "SELECT SUM(s.nNidi) FROM Sito s WHERE s.regione = :regione GROUP BY s.regione")
})
public class Sito implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String FIND_ALL = "Sito.findAll";
    public static final String FIND_BY_ID = "Sito.findById";
    public static final String FIND_BY_DATA = "Sito.findByData";
    public static final String FIND_BY_REGIONE = "Sito.findByRegione";
    public static final String FIND_BY_INTERVENTO = "Sito.findByIntervento";
    public static final String NIDI_BY_REGIONE = "Sito.nidiByRegione";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String regione;
    private String nome;
    private Date data;
    private int nNidi;
    private int nUova;
    private boolean isNuovo;
    private boolean intervento;

    public Sito() {
    }
    
    public Sito(int id, Date date, String regione, String nome, int nNidi, int nUova, boolean isNuovo, boolean intervento) {
        this.id = id;
        this.regione = regione;
        this.nome = nome;
        this.data = date;
        this.nNidi = nNidi;
        this.nUova = nUova;
        this.isNuovo = isNuovo;
        this.intervento = intervento;
    }

    public Sito(Date date, String regione, String nome, int nNidi, int nUova, boolean isNuovo, boolean intervento) {
        this.regione = regione;
        this.nome = nome;
        this.data = date;
        this.nNidi = nNidi;
        this.nUova = nUova;
        this.isNuovo = isNuovo;
        this.intervento = intervento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDate() {
        return data;
    }

    public void setDate(Date date) {
        this.data = date;
    }

    public int getnNidi() {
        return nNidi;
    }

    public void setnNidi(int nNidi) {
        this.nNidi = nNidi;
    }

    public int getnUova() {
        return nUova;
    }

    public void setnUova(int nUova) {
        this.nUova = nUova;
    }

    public boolean isIsNuovo() {
        return isNuovo;
    }

    public void setIsNuovo(boolean isNuovo) {
        this.isNuovo = isNuovo;
    }

    public boolean isIntervento() {
        return intervento;
    }

    public void setIntervento(boolean intervento) {
        this.intervento = intervento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.regione);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.data);
        hash = 71 * hash + this.nNidi;
        hash = 71 * hash + this.nUova;
        hash = 71 * hash + (this.isNuovo ? 1 : 0);
        hash = 71 * hash + (this.intervento ? 1 : 0);
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
        final Sito other = (Sito) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nNidi != other.nNidi) {
            return false;
        }
        if (this.nUova != other.nUova) {
            return false;
        }
        if (this.isNuovo != other.isNuovo) {
            return false;
        }
        if (this.intervento != other.intervento) {
            return false;
        }
        if (!Objects.equals(this.regione, other.regione)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sito{" + "id=" + id + ", regione=" + regione + ", nome=" + nome + ", date=" + data + ", nNidi=" + nNidi + ", nUova=" + nUova + ", isNuovo=" + isNuovo + ", intervento=" + intervento + '}';
    }
    
}
