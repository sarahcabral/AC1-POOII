package com.atividades.ac1poo.controllers;

import java.util.List;

import com.atividades.ac1poo.dtos.EventDTO;
import com.atividades.ac1poo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents() {
        List <EventDTO> list = service.getEvents();
        return ResponseEntity.ok().body(list);
    }

}