package metier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adrien
 */
@Entity
@Table(name = "DEPLACEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deplacement.findAll", query = "SELECT d FROM Deplacement d")
    , @NamedQuery(name = "Deplacement.findById", query = "SELECT d FROM Deplacement d WHERE d.id = :id")
    , @NamedQuery(name = "Deplacement.findByDate", query = "SELECT d FROM Deplacement d WHERE d.date = :date")
    , @NamedQuery(name = "Deplacement.findByMode", query = "SELECT d FROM Deplacement d WHERE d.mode = :mode")
    , @NamedQuery(name = "Deplacement.findByDistanceparcourue", query = "SELECT d FROM Deplacement d WHERE d.distanceparcourue = :distanceparcourue")
    , @NamedQuery(name = "Deplacement.findByJourtravaille", query = "SELECT d FROM Deplacement d WHERE d.jourtravaille = :jourtravaille")})
public class Deplacement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Column(name = "MODE")
    private String mode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISTANCEPARCOURUE",precision=5,scale=2)
    private BigDecimal distanceparcourue;
    @Column(name = "JOURTRAVAILLE")
    private Boolean jourtravaille;

    public Deplacement() {
    }

    public Deplacement(Long id) {
        this.id = id;
    }

    public Deplacement(Date date, String mode, BigDecimal distanceparcourue, Boolean jourtravaille) {
        this.date = date;
        this.mode = mode;
        this.distanceparcourue = distanceparcourue;
        this.jourtravaille = jourtravaille;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public BigDecimal getDistanceparcourue() {
        return distanceparcourue;
    }

    public void setDistanceparcourue(BigDecimal distanceparcourue) {
        this.distanceparcourue = distanceparcourue;
    }

    public Boolean getJourtravaille() {
        return jourtravaille;
    }

    public void setJourtravaille(Boolean jourtravaille) {
        this.jourtravaille = jourtravaille;
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
        if (!(object instanceof Deplacement)) {
            return false;
        }
        Deplacement other = (Deplacement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Deplacement[ id=" + id + " ]";
    }

}
