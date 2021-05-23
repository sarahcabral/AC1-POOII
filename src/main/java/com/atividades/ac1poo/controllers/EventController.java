package com.atividades.ac1poo.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import com.atividades.ac1poo.services.EventService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.atividades.ac1poo.dtos.*;
import java.net.URI;

@RestController
@RequestMapping("/events")
public class EventController {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Autowired
    private EventService eventService;

    /**
     * _______
     * @ROUTES 
     * |||||||
     */
    
    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(
        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy, 
        @RequestParam(value = "name",         defaultValue = "") String name, 
        @RequestParam(value = "description",  defaultValue = "") String description, 
        @RequestParam(value = "emailContact",  defaultValue = "") String emailContact, 
        @RequestParam(value = "startDate",    defaultValue = "") String startDate
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page <EventDTO> list = eventService.getEvents(pageRequest, name.trim(), description.trim(), emailContact.trim(), startDate);
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id){
        EventDTO dto = eventService.getEventById(id);

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<EventDTO> insert (@RequestBody EventInsertDTO insertDTO) {
        EventDTO dto = eventService.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<EventDTO> update(@RequestBody EventUpdateDTO updateDTO, @PathVariable Long id) {
        EventDTO dto = eventService.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }
    
    /*
    @PutMapping("{id}/places/{id}")
    public ResponseEntity<EventDTO> update(@RequestBody EventUpdateDTO updateDTO, @PathVariable Long id) {
        EventDTO dto = eventService.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }
    */

    @DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		eventService.delete(id); 
		return ResponseEntity.noContent().build();
	}
}
