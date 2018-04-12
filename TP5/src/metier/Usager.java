package metier;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Usager.findAll", query = "SELECT u FROM Usager u"),
    @NamedQuery(name = "Usager.deleteAll", query = "DELETE FROM Usager")
    , @NamedQuery(name = "Usager.findByEmail", query = "SELECT u FROM Usager u WHERE u.email = :email")})
public class Usager implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "EMAIL", unique=true)
    private String email;
    @Lob
    @Column(name = "PASSWORD")
    private String password;

    // un usager peut avoir plusieurs déplacements
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "nUsager")
    private Collection<Deplacement> listeDeplacement;
    
    public Usager() {
        listeDeplacement = new HashSet<Deplacement>();
    }

    public Usager(String email) {
        this();
        this.email = email;
    }

    public Usager(String email, String password) {
        this();
        this.email = email;
        this.password = password;
    }
    
    public boolean addDeplacement(Deplacement d){
        if(listeDeplacement.add(d)){
            d.setnUsager(this);
            return true;
        }
        return false;
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

    public Collection<Deplacement> getListeDeplacement() {
        return listeDeplacement;
    }

    public void setListeDeplacement(Collection<Deplacement> listeDeplacement) {
        this.listeDeplacement = listeDeplacement;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.password);
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
        final Usager other = (Usager) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Usager{" + "email=" + email + ", password=" + password + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
