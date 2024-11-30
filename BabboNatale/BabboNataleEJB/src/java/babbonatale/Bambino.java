package babbonatale;

import static babbonatale.Bambino.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = "Select b FROM Bambino b"),
    @NamedQuery(name = FIND_BY_REQUEST, query = "SELECT b FROM Bambino b WHERE b.stato = false"),
    @NamedQuery(name = FIND_NUCLEO, query = "SELECT b FROM Bambino b WHERE b.nucleo > :nucleoMinimo"),
    @NamedQuery(name = FIND_BY_ID, query = "SELECT b FROM Bambino b WHERE b.id = :id")
    
}
)
public class Bambino implements Serializable {

    public static final String FIND_ALL = "Bambino.findAllBambini";
    public static final String FIND_BY_REQUEST = "Bambino.findBambiniByStato";
    public static final String FIND_NUCLEO = "Bambino.findBambiniByNucleo";
    public static final String FIND_BY_ID = "Bambino.findBambiniById";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cognome; 
    private String citta;
    private String paese; 
    private int eta;
    private int nucleo;
    private Boolean stato; 
    private String priorita;

    public Bambino(Long id, String CognomeNome, String citta, String Paese, int eta, int numeroNucleo, Boolean stato, String priorita) {
        this.id = id;
        this.cognome = CognomeNome;
        this.citta = citta;
        this.paese = Paese;
        this.eta = eta;
        this.nucleo = numeroNucleo;
        this.stato = stato;
        this.priorita = priorita;
    }

    public Bambino() {
    }

    public Bambino(String CognomeNome, String citta, String Paese, int eta, int numeroNucleo, Boolean stato, String priorita) {
        this.cognome = CognomeNome;
        this.citta = citta;
        this.paese = Paese;
        this.eta = eta;
        this.nucleo = numeroNucleo;
        this.stato = stato;
        this.priorita = priorita;
    }

    public void setCognomeNome(String CognomeNome) {
        this.cognome = CognomeNome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setPaese(String Paese) {
        this.paese = Paese;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setNumeroNucleo(int numeroNucleo) {
        this.nucleo = numeroNucleo;
    }

    public void setStato(Boolean stato) {
        this.stato = stato;
    }

    public void setPriorita(String priorita) {
        this.priorita = priorita;
    }
    
    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCognomeNome() {
        return cognome;
    }

    public String getCitta() {
        return citta;
    }

    public String getPaese() {
        return paese;
    }

    public int getEta() {
        return eta;
    }

    public int getNumeroNucleo() {
        return nucleo;
    }

    public Boolean getStato() {
        return stato;
    }

    public String getPriorita() {
        return priorita;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bambino)) {
            return false;
        }
        Bambino other = (Bambino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bambino{" + "id=" + id + ", cognome=" + cognome + ", citta=" + citta + ", paese=" + paese + ", eta=" + eta + ", nucleo=" + nucleo + ", stato=" + stato + ", priorita=" + priorita + '}';
    }   
}