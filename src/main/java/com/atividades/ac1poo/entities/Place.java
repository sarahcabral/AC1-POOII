package com.atividades.ac1poo.entities;
import java.io.Serializable;
import javax.persistence.*;

import com.atividades.ac1poo.dtos.PlaceInsertDTO;

import java.util.*;

@Entity
@Table(name="TB_PLACE")
public class Place implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    
    @ManyToMany(mappedBy="places")
    private List<Event> events = new ArrayList<>();

    /**
     * -------------
     * @Constructors
     * -------------
     */
    public Place() {}
    public Place(Long id, String name, String address){
        this.name = name;
        this.address = address;
    }
    public Place(PlaceInsertDTO insertDTO){
        setName(insertDTO.getName());
        setAddress(insertDTO.getAddress());
    }
    /**
     * ------------------
     * @GettersAndSetters
     * ------------------
     */
    public String getAddress() {
        return address;
    }
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
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Event> getEvents(){
        return events;
    }

    public void addEvents(  Event event ){

        //                     String description,
        //                     LocalDate startDate,
        //                     LocalDate endDate,
        //                     LocalTime startTime,
        //                     LocalTime endTime,
        //                     String emailContact,
        //                     Long amountFreeTickets,
        //                     Long amountPayedTickets,
        //                     Long freeTicketsSelled,
        //                     Long payedTicketsSelled,
        //                     Double priceTicket) {

        // Event event = new Event();
        // event.setDescription(description);
        // event.setStartDate(startDate);
        // event.setEndDate(endDate);
        // event.setStartTime(startTime);
        // event.setEndTime(endTime);
        // event.setEmailContact(emailContact);
        // event.setAmountFreeTickets(amountFreeTickets);
        // event.setAmountPayedTickets(amountPayedTickets);
        // event.setPayedTicketsSelled(payedTicketsSelled);
        // event.setPriceTicket(priceTicket);
        // this.events.add(event);
        this.events.add(event);

    }
}
