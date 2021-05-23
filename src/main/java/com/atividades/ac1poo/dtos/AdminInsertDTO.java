package com.atividades.ac1poo.dtos;

public class AdminInsertDTO {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    private String name;
    private String email;
    private Integer phoneNumber;

    /**
     * @Constructors
     */
    public AdminInsertDTO(){}
    public AdminInsertDTO(String name, String email, Integer phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @Getters_and_Setters
     */
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
 