package com.atividades.ac1poo.entities;
import javax.persistence.*;

import com.atividades.ac1poo.dtos.AttendInsertDTO;

@Entity
@Table(name="TB_ATTEND")
@PrimaryKeyJoinColumn(name="ID")
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
    
    public Attend(AttendInsertDTO insetDTO){
        setName(insetDTO.getName());
        setEmail(insetDTO.getEmail());
        setBalance(insetDTO.getBalance());
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
