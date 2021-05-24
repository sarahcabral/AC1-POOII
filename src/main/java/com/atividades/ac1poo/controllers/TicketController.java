package com.atividades.ac1poo.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.atividades.ac1poo.services.TicketService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.atividades.ac1poo.dtos.*;
import java.net.URI;

@RestController
@RequestMapping("/tickets")
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
    
    @GetMapping("{id}")
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
