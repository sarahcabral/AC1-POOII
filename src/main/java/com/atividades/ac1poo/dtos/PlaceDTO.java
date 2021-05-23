package com.atividades.ac1poo.dtos;

import com.atividades.ac1poo.entities.Place;

public class PlaceDTO {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    private Long id;
    private String name;
    private String address;
    private Long idEvent;

    /**
     * @Constructors
     */
    public PlaceDTO(){}
    public PlaceDTO(Long id, String name, String address, Long idEvent) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idEvent = idEvent;
    }

    public PlaceDTO(Place entity) {
        setName(entity.getName());
        setAddress(entity.getAddress());
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getIdEvent() {
        return idEvent;
    }
    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }
    
}
 