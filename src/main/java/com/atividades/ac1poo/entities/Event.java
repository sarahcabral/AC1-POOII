package com.atividades.ac1poo.entities;

import com.atividades.ac1poo.dtos.EventInsertDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name="TB_EVENT")
public class Event implements Serializable{

    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    private String emailContact;
    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Long freeTicketsSelled;
    private Long payedTicketsSelled;
    private Double priceTicket;

    @ManyToOne
    // @JoinColumn(name="ADMIN_ID")
    private Admin admin;

    @ManyToMany
    @JoinTable(name="EVENTS_PLACES",
            joinColumns = @JoinColumn(name="EVENTS_ID"),
            inverseJoinColumns = @JoinColumn(name="PLACES_ID"))
    // @JoinColumn(name="PLACES_ID")
    private List<Place> places = new ArrayList<>();

    /**
     * -------------
     * @Constructors
     * -------------
     */
    public Event() {}
    public Event(String name, String description, Double priceTicket){
        this.name = name;
        this.description = description;
        this.priceTicket = priceTicket;
    }
    public Event(EventInsertDTO insertDTO, Admin adm) {
        setName(insertDTO.getName());
        setDescription(insertDTO.getDescription());
        setStartDate(insertDTO.getStartDate());
        setEndDate(insertDTO.getEndDate());
        setStartTime(insertDTO.getStartTime());
        setEndTime(insertDTO.getEndTime());
        setEmailContact(insertDTO.getEmailContact());
        setAmountFreeTickets(insertDTO.getAmountFreeTickets());
        setAmountPayedTickets(insertDTO.getAmountPayedTickets());
        setPriceTicket(insertDTO.getPriceTicket());
        setAdmin(adm);
    }
    /**
     * ------------------
     * @GettersAndSetters
     * ------------------
     */
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPriceTicket() {
        return priceTicket;
    }
    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public String getEmailContact() {
        return emailContact;
    }
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }
    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }
    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }
    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }
    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }
    public Long getFreeTicketsSelled() {
        return freeTicketsSelled;
    }
    public void setFreeTicketsSelled(Long freeTicketsSelled) {
        this.freeTicketsSelled = freeTicketsSelled;
    }
    public Long getPayedTicketsSelled() {
        return payedTicketsSelled;
    }
    public void setPayedTicketsSelled(Long payedTicketsSelled) {
        this.payedTicketsSelled = payedTicketsSelled;
    }
    public List<Place> getPlaces() {
        return places;
    }
    public void addPlaces(Place place) {
        this.places.add(place);
    }
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
}
