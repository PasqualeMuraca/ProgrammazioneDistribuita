/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import static server.Vino.*;
/**
 *
 * @author CORSO_PD
 */
@Entity
@Table(name = "Vino")
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "SELECT v FROM Vino v"),
    @NamedQuery(name = FIND_BY_ID, query = "SELECT v FROM Vino v WHERE v.id = :id"),
    @NamedQuery(name = FIND_BY_PREZZO, query = "SELECT v FROM Vino v WHERE v.prezzo = :prezzo"),
    @NamedQuery(name = FIND_BY_VITIGNO, query = "SELECT v FROM Vino v WHERE v.vitigno = :vitigno"),
    @NamedQuery(name = FIND_BY_PROVENIENZA, query = "SELECT v FROM Vino v WHERE v.provenienza = :provenienza"),
    @NamedQuery(name = FIND_LOWER_THAN_PREZZO, query = "SELECT v FROM Vino v WHERE v.prezzo < :limiteSup"),
})
public class Vino implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String FIND_ALL = "Vino.findAll";
    public static final String FIND_BY_ID = "Vino.findById";
    public static final String FIND_BY_PREZZO = "Vino.findByPrezzo";
    public static final String FIND_BY_VITIGNO = "Vino.findByVitigno";
    public static final String FIND_BY_PROVENIENZA = "Vino.findByProvenienza";    
    public static final String FIND_LOWER_THAN_PREZZO = "Vino.findLowerThanPrezzo";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nominativo;
    private String vitigno;
    private String azienda;
    private int bottiglie;
    private String provenienza;
    private double prezzo;
    private String tipologia;
    private boolean acquisto;

    public Vino() {
    }

    public Vino(int id, String nominativo, String vitigno, String azienda, int bottiglie, String provenienza, double prezzo, String tipologia, boolean acquisto) {
        this.id = id;
        this.nominativo = nominativo;
        this.vitigno = vitigno;
        this.azienda = azienda;
        this.bottiglie = bottiglie;
        this.provenienza = provenienza;
        this.prezzo = prezzo;
        this.tipologia = tipologia;
        this.acquisto = acquisto;
    }

    public Vino(String nominativo, String vitigno, String azienda, int bottiglie, String provenienza, double prezzo, String tipologia, boolean acquisto) {
        this.nominativo = nominativo;
        this.vitigno = vitigno;
        this.azienda = azienda;
        this.bottiglie = bottiglie;
        this.provenienza = provenienza;
        this.prezzo = prezzo;
        this.tipologia = tipologia;
        this.acquisto = acquisto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getVitigno() {
        return vitigno;
    }

    public void setVitigno(String vitigno) {
        this.vitigno = vitigno;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public int getBottiglie() {
        return bottiglie;
    }

    public void setBottiglie(int bottiglie) {
        this.bottiglie = bottiglie;
    }

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public boolean isAcquisto() {
        return acquisto;
    }

    public void setAcquisto(boolean acquisto) {
        this.acquisto = acquisto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.nominativo);
        hash = 67 * hash + Objects.hashCode(this.vitigno);
        hash = 67 * hash + Objects.hashCode(this.azienda);
        hash = 67 * hash + this.bottiglie;
        hash = 67 * hash + Objects.hashCode(this.provenienza);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.prezzo) ^ (Double.doubleToLongBits(this.prezzo) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.tipologia);
        hash = 67 * hash + (this.acquisto ? 1 : 0);
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
        final Vino other = (Vino) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.bottiglie != other.bottiglie) {
            return false;
        }
        if (Double.doubleToLongBits(this.prezzo) != Double.doubleToLongBits(other.prezzo)) {
            return false;
        }
        if (this.acquisto != other.acquisto) {
            return false;
        }
        if (!Objects.equals(this.nominativo, other.nominativo)) {
            return false;
        }
        if (!Objects.equals(this.vitigno, other.vitigno)) {
            return false;
        }
        if (!Objects.equals(this.azienda, other.azienda)) {
            return false;
        }
        if (!Objects.equals(this.provenienza, other.provenienza)) {
            return false;
        }
        if (!Objects.equals(this.tipologia, other.tipologia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vino{" + "id=" + id + ", nominativo=" + nominativo + ", vitigno=" + vitigno + ", azienda=" + azienda + ", bottiglie=" + bottiglie + ", provenienza=" + provenienza + ", prezzo=" + prezzo + ", tipologia=" + tipologia + ", acquisto=" + acquisto + '}';
    }
    
}
