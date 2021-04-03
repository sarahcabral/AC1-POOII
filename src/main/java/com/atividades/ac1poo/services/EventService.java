package com.atividades.ac1poo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import com.atividades.ac1poo.dtos.EventDTO;
import com.atividades.ac1poo.dtos.EventInsertDTO;
import com.atividades.ac1poo.dtos.EventUpdateDTO;
import com.atividades.ac1poo.entities.Event;
import com.atividades.ac1poo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repo;

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
    
    public EventDTO getEventById(Long id) {
        Optional<Event> op = repo.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        return new EventDTO(event);
    }

    public EventDTO insert(EventInsertDTO insertDTO) {
        Event entity = new Event(insertDTO);
        if(entity.getEndDate().isAfter(entity.getStartDate()))
        {
            entity = repo.save(entity);
            return new EventDTO(entity);
        } else if((entity.getEndDate().isEqual(entity.getStartDate())) && (entity.getEndTime().isAfter(entity.getStartTime())   )){
            entity = repo.save(entity);
            return new EventDTO(entity);
        } 
        else 
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data final do evento deve ser posterior a inicial");
    }

    public EventDTO update(Long id, EventUpdateDTO updateDTO) {
        try {
            Event entity = repo.getOne(id);
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
              
            entity = repo.save(entity);
            return new EventDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de data incorreto - Inserir dados no formato 'dd-MM-yyyy'"); 
        }
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    /*
    private List<EventDTO> toDTOList(List<Event> list) {
        List<EventDTO> listDTO = new ArrayList<>();

        for (Event e : list) {
            listDTO.add(new EventDTO(e.getId(),e.getName(),e.getDescription(),e.getStartDate(),e.getEndDate(),e.getStartTime(),e.getEndTime()));
        }
        return listDTO;
    }
    */
}
