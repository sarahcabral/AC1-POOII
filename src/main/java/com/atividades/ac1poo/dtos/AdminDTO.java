package com.atividades.ac1poo.dtos;

import com.atividades.ac1poo.entities.Admin;

public class AdminDTO {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    private Long id;
    private String name;
    private String email;
    private Integer phoneNumber;

    /**
     * @Constructors
     */
    public AdminDTO(){}
    public AdminDTO(Long id, String name, String email, Integer phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public AdminDTO(Admin entity) {
        setId(entity.getId());
        setName(entity.getName());
        setEmail(entity.getEmail());
        setPhoneNumber(entity.getPhoneNumber());
    }
    /**
     * @Getters_and_Setters
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
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
 