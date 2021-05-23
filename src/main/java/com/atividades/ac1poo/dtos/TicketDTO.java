package com.atividades.ac1poo.dtos;

import com.atividades.ac1poo.entities.TicketType;
import com.atividades.ac1poo.entities.Ticket;
import java.time.Instant;

public class TicketDTO {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    private Long id;
    private Double price;
    private Instant date;
    private TicketType type;

    /**
     * @Constructors
     */
    public TicketDTO(){}
    public TicketDTO(Long id, Double price, Instant date, TicketType type) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.price = price;
    }

    public TicketDTO(Ticket entity) {
        setPrice(entity.getPrice());
        setType(entity.getType());
        setDate(entity.getDate());
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
    public Instant getDate() {
        return date;
    }
    public void setDate(Instant date) {
        this.date = date;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public TicketType getType() {
        return type;
    }
    public void setType(TicketType type) {
        this.type = type;
    }

}
 