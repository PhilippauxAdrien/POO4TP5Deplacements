package metier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Deplacement.findAll", query = "SELECT d FROM Deplacement d"),
    @NamedQuery(name = "Deplacement.deleteAll", query = "DELETE FROM Deplacement")
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
    private Double distanceparcourue;
    @Column(name = "JOURTRAVAILLE")
    private Boolean jourtravaille;

    @JoinColumn(name = "nUsager", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    // un déplacement ne posséde qu'un usager
    private Usager nUsager;
    
    public Deplacement() {
    }

    public Deplacement(Long id) {
        this.id = id;
    }

    public Deplacement(Date date, String mode, Double distanceparcourue, Boolean jourtravaille) {
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

    public Double getDistanceparcourue() {
        return distanceparcourue;
    }

    public void setDistanceparcourue(Double distanceparcourue) {
        this.distanceparcourue = distanceparcourue;
    }

    public Boolean getJourtravaille() {
        return jourtravaille;
    }

    public void setJourtravaille(Boolean jourtravaille) {
        this.jourtravaille = jourtravaille;
    }

    public Usager getnUsager() {
        return nUsager;
    }

    public void setnUsager(Usager nUsager) {
        this.nUsager = nUsager;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.date);
        hash = 41 * hash + Objects.hashCode(this.mode);
        hash = 41 * hash + Objects.hashCode(this.distanceparcourue);
        hash = 41 * hash + Objects.hashCode(this.jourtravaille);
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
        final Deplacement other = (Deplacement) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Deplacement{" + "id=" + id + ", date=" + date + ", mode=" + mode + ", distanceparcourue=" + distanceparcourue + ", jourtravaille=" + jourtravaille + '}';
    }

}
