package com.atividades.ac1poo.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TB_TICKET")
public class Ticket implements Serializable{
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Instant date;
    private Double price;
    private TickerType type;

    /**
     * -------------
     * @Constructors
     * -------------
     */
    public Ticket(){}
    public Ticket(Instant date, Double price){
        this.date = date;
        this.price = price;
    }
    /**
     * --------------------
     * @Getters_and_Setters
     * --------------------
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
    public TickerType getType() {
        return type;
    }
    public void setType(TickerType type) {
        this.type = type;
    }
    /**
     * --------------------
     * @HashCode_and_Equals
     * -------------------- 
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ticket other = (Ticket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }    
}
