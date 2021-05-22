package com.atividades.ac1poo.entities;
import javax.persistence.*;

@Entity
@Table(name="TB_ATTENDEES")
public class Attend extends BaseUser{

    /**
     * ------------
     * @Declaration
     * ------------
     */
    private Double balance;

    /**
     * -------------
     * @Constructors
     * -------------
     */
    public Attend() {}
    public Attend(Long id, String name, String email, Double balance){
        super(id, name, email);
        this.balance = balance;
    }
    /**
     * ------------------
     * @GettersAndSetters
     * ------------------
     */
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
}
