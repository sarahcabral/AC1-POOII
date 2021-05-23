package com.atividades.ac1poo.dtos;

import com.atividades.ac1poo.entities.Attend;

public class AttendDTO {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    private Long id;
    private String name;
    private String email;
    private Double balance;

    /**
     * @Constructors
     */
    public AttendDTO(){}
    public AttendDTO(Long id, String name, String email, Double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;

    }

    public AttendDTO(Attend entity) {
        setName(entity.getName());
        setEmail(entity.getEmail());
        setBalance(entity.getBalance());
    }
 
    /**
     * @Getters_and_Setters
     */
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
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
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
 