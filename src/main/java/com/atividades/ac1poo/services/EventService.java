package com.atividades.ac1poo.services;

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

    public Page<EventDTO> getEvents(PageRequest pageRequest) {
        Page<Event> list = repo.find(pageRequest);
        
        return list.map( e -> new EventDTO(e));
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
        } /* else if(entity.getEndDate().isEqual(entity.getStartDate()))
        {
            if(entity.getEndTime().isAfter(entity.getStartTime()))
            {

            }
        } */ else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data final do evento deve ser posterior a inicial");          
        } 
    }

    public EventDTO update(Long id, EventUpdateDTO updateDTO) {
        try {
            Event entity = repo.getOne(id);
            entity.setName(updateDTO.getName());
            entity.setDescription(updateDTO.getDescription());
            entity.setEndDate(updateDTO.getEndDate());
            entity.setEndTime(updateDTO.getEndTime());
            entity.setStartDate(updateDTO.getStartDate());
            entity.setStartTime(updateDTO.getStartTime());
            entity = repo.save(entity);
            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }// catch ()
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }




}
