package com.atividades.ac1poo.dtos;

public class PlaceUpdateDTO {
    
    /**
     * @Declaration
     */
    private String name;
    private String address;

    /**
     * @Getters_and_Setter
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }    
}
