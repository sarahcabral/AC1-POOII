package com.atividades.ac1poo.entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="TB_BASEUSER")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseUser implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;


    /**
     * -------------
     * @Constructors
     * -------------
     */
    public BaseUser() {}
    public BaseUser(Long id, String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    /**
     * ------------------
     * @GettersAndSetters
     * ------------------
     */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * ------------------
     * @HashCodeAndEquals
     * ------------------
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseUser other = (BaseUser) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}