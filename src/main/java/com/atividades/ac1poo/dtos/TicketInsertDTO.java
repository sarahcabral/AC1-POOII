package com.atividades.ac1poo.dtos;

import java.time.Instant;

import com.atividades.ac1poo.entities.TicketType;

public class TicketInsertDTO {
    
    /**
     * @Declaration
     */
    private Instant date;
    private Double price;
    private TicketType type;

    /**
     * @Getters_and_Setters
     */
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
