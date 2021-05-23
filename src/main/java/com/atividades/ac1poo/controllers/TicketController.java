package com.atividades.ac1poo.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.atividades.ac1poo.services.TicketService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.atividades.ac1poo.dtos.*;
import java.net.URI;

@RestController
@RequestMapping("/events/{id}/tickets")
public class TicketController {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Autowired
    private TicketService ticketService;

    /**
     * _______
     * @ROUTES
     * |||||||
     */
    /*
    @GetMapping
    public ResponseEntity<Page<TicketDTO>> getTickets(
        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy, 
        @RequestParam(value = "name",         defaultValue = "") String name, 
        @RequestParam(value = "place",        defaultValue = "") String place, 
        @RequestParam(value = "description",  defaultValue = "") String description, 
        @RequestParam(value = "startD   ate",    defaultValue = "") String startDate
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page <TicketDTO> list = service.getTickets(pageRequest, name.trim(), place.trim(), description.trim(), startDate);
        return ResponseEntity.ok().body(list);
    }*/
    
    @GetMapping
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id){
        TicketDTO dto = ticketService.getTicketById(id);
 
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<TicketDTO> insert (@RequestBody TicketInsertDTO insertDTO) {
        TicketDTO dto = ticketService.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ticketService.delete(id); 
		return ResponseEntity.noContent().build();
	}
}
