package com.atividades.ac1poo.services;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.atividades.ac1poo.repositories.*;
import org.springframework.http.HttpStatus;
import com.atividades.ac1poo.entities.*;
import com.atividades.ac1poo.dtos.*;
import java.util.Optional;

@Service
public class TicketService{      
   
    @Autowired
    private TicketRepository ticketRepository;

    public TicketDTO getTicketById(Long id) {
        Optional<Ticket> op = ticketRepository.findById(id);
        Ticket ticket = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found anywhere. It may never have been scheduled"));
        return new TicketDTO(ticket);
    } 

    public TicketDTO insert(TicketInsertDTO insertDTO){
        Ticket entity = new Ticket(insertDTO);
        ticketRepository.save(entity);
        return new TicketDTO(entity);
    }
    
    public void delete(Long id) {
        try{
            Ticket ticket = catchTicketById(id);
            ticketRepository.delete(ticket);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
        }  catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
        }
    }
    private Ticket catchTicketById(Long id){
        try{
            Ticket tkt = ticketRepository.getOne(id);
            return tkt;
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERROR"); 
        }
    }
}