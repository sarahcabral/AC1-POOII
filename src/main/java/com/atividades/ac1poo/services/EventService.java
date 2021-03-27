package com.atividades.ac1poo.services;

import java.util.ArrayList;
import java.util.List;

import com.atividades.ac1poo.dtos.EventDTO;
import com.atividades.ac1poo.entities.Event;
import com.atividades.ac1poo.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repo;

    public List<EventDTO> getEvents() {
        List<Event> list = repo.findAll();
        return toDTOList(list);
    }

    private List<EventDTO> toDTOList(List<Event> list) {
        List<EventDTO> listDTO = new ArrayList<>();

        for (Event e : list) {
            listDTO.add(new EventDTO(e.getId(),e.getName(),e.getDescription(),e.getStartDate(),e.getEndDate(),e.getStartTime(),e.getEndTime()));
        }
        return listDTO;
    }
}
