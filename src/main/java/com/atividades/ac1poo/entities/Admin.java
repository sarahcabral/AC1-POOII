package com.atividades.ac1poo.entities;
import javax.persistence.*;

import com.atividades.ac1poo.dtos.AdminInsertDTO;

import java.util.*;

@Entity
@Table(name="TB_ADMINS")
public class Admin extends BaseUser{

    /**
     * ------------
     * @Declaration
     * ------------
     */
    private Integer phoneNumber;

    @OneToMany(mappedBy="admin")
    private List<Event> events = new ArrayList<>();

    /**
     * -------------
     * @Constructors
     * -------------
     */
    public Admin() {}
    public Admin(Long id, String name, String email, Integer phoneNumber){
        super(id, name, email);
        this.phoneNumber = phoneNumber;
    }
    public Admin(AdminInsertDTO insertDTO) {
        setName(insertDTO.getName());
        setEmail(insertDTO.getEmail());
        setPhoneNumber(insertDTO.getPhoneNumber());
    }
    /**
     * ------------------
     * @GettersAndSetters
     * ------------------
     */
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<Event> getEvents() {
        return events;
    }
    public void addEvents(Event event) {
        this.events.add(event);
    }
    
}
