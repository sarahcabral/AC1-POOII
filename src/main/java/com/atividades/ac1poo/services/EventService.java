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
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EventService{

    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private PlaceRepository placeRepository;
/*
    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String place, String description, String data) {
         
        if (data.isEmpty() || (data.length() < 1)) {
            Page<Event> list = repo.find(pageRequest, name, place, description);
            return list.map( e -> new EventDTO(e));
        } else {
            try {         
                //LocalDate startDate = LocalDate.parse(data, DateTimeFormatter.ISO_DATE);
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
                LocalDate startDate = LocalDate.parse(data, formato); 
                Page<Event> list = repo.find(pageRequest, name, place, description, startDate);
                return list.map( e -> new EventDTO(e));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de data incorreto - Inserir dados no formato 'dd-MM-yyyy'");
            }
        }       
    }
*/

    public EventDTO getEventById(Long id) {
        Optional<Event> op = eventRepository.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found anywhere. It may never have been scheduled"));
        return new EventDTO(event);
    } 

    public EventDTO insert(EventInsertDTO insertDTO){
        if((adminRepository.findById(insertDTO.getIdAdmin())) != null){
            // Optional<Admin> opAdmin = adminRepository.findById(insertDTO.getIdAdmin());
            // Admin adm = opAdmin.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unknown error..."));         
            Event entity = new Event(insertDTO, getAdminById(insertDTO.getIdAdmin()), getPlaceById(insertDTO.getIdPlace()));
            
            if(entity.getEndDate().isAfter(entity.getStartDate()) || 
            ((entity.getEndDate().isEqual(entity.getStartDate())) && (entity.getEndTime().isAfter(entity.getStartTime())))){
                if(checkListOfDateEvents(getPlaceById(insertDTO.getIdPlace()), entity.getStartDate(), entity.getEndDate())){
                    entity = eventRepository.save(entity);
                    return new EventDTO(entity);
                } 
                else{
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN, "There is another event scheduled!");
                }
            } 
            else 
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The closing event date must start after the starting date!");
        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There are no admin with the ID informed!");  
    }

    public EventDTO update(Long id, EventUpdateDTO updateDTO) {
        try{
            Event entity = eventRepository.getOne(id);
            if(entity.getStartDate().isAfter(LocalDate.now())){
                if(updateDTO.getIdPlace() != null)       
                    entity.addPlaces(getPlaceById(updateDTO.getIdPlace()));
                if(!updateDTO.getName().isEmpty())       
                    entity.setName(updateDTO.getName());
                if(!updateDTO.getDescription().isEmpty()) 
                    entity.setDescription(updateDTO.getDescription());
                if(updateDTO.getStartDate() != null) 
                    entity.setStartDate(updateDTO.getStartDate());
                if(updateDTO.getEndDate() != null) 
                    entity.setEndDate(updateDTO.getEndDate());
                if(updateDTO.getStartTime() != null) 
                    entity.setStartTime(updateDTO.getStartTime());
                if(updateDTO.getEndTime() != null) 
                    entity.setEndTime(updateDTO.getEndTime());
            }
            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de data incorreto - Inserir dados no formato 'dd-MM-yyyy'"); 
        }
    }
    
    public void delete(Long id) {
        try{
            Event event = eventRepository.getOne(id);   
            if(event.getFreeTicketsSelled() <= 0 && event.getPayedTicketsSelled() <= 0){
                try {
                    eventRepository.deleteById(id);
                } catch (EmptyResultDataAccessException e) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
                }
            }
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }  
    }
    private Admin getAdminById(Long id){
        try{
            Admin adm = adminRepository.getOne(id);
            return adm;
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "SLA"); 
        }
    }

    private Place getPlaceById(Long id){
        try{
            Place place = placeRepository.getOne(id);
            return place;
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "SLA"); 
        }
    }

    private boolean checkListOfDateEvents(Place place, LocalDate startDateEvent, LocalDate endDateEvent){
        
        for(Event event: place.getEvents()){
            if(event.getStartDate().isBefore(startDateEvent) && event.getEndDate().isAfter(startDateEvent)){
                return false;
            }
            else if(event.getStartDate().isAfter(startDateEvent) && event.getEndDate().isBefore(endDateEvent)){
                return false;
            }
            else if(event.getStartDate().isBefore(endDateEvent) && event.getEndDate().isAfter(endDateEvent)){
                return false;
            }
        }
        return true;
    }
}