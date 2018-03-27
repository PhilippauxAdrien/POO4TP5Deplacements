package metier;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adrien
 */
@Entity
@Table(name = "USAGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usager.findAll", query = "SELECT u FROM Usager u")
    , @NamedQuery(name = "Usager.findByEmail", query = "SELECT u FROM Usager u WHERE u.email = :email")})
public class Usager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Lob
    @Column(name = "PASSWORD")
    private String password;

    public Usager() {
    }

    public Usager(String email) {
        this.email = email;
    }

    public Usager(String email, String password) {
        this.email = email;
        this.password = password;
    }
     
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usager)) {
            return false;
        }
        Usager other = (Usager) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Usager[ email=" + email + " ]";
    }

}
