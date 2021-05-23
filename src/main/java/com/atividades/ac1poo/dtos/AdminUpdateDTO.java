package com.atividades.ac1poo.dtos;

public class AdminUpdateDTO {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    private String name;
    private Integer phoneNumber;

    /**
     * @Constructors
     */
    public AdminUpdateDTO(){}
    public AdminUpdateDTO(String name, Integer phoneNumber) {
        this.name = name;
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
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
 