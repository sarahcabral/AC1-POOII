package com.atividades.ac1poo.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.atividades.ac1poo.services.AttendService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.atividades.ac1poo.dtos.*;
import java.net.URI;

@RestController
@RequestMapping("/attendees")
public class AttendController {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Autowired
    private AttendService attendService;

    /**
     * _______
     * @ROUTES
     * |||||||
     */
    
    @GetMapping
    public ResponseEntity<Page<AttendDTO>> getAttend(
        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy, 
        @RequestParam(value = "name",         defaultValue = "") String name,
        @RequestParam(value = "emailContact", defaultValue = "") String emailContact
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page <AttendDTO> list = attendService.getAttend(pageRequest, name.trim(), emailContact.trim());
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<AttendDTO> getAttendById(@PathVariable Long id){
        AttendDTO dto = attendService.getAttendById(id);
 
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<AttendDTO> insert (@RequestBody AttendInsertDTO insertDTO) {
        AttendDTO dto = attendService.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<AttendDTO> update(@RequestBody AttendUpdateDTO updateDTO, @PathVariable Long id) {
        AttendDTO dto = attendService.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		attendService.delete(id); 
		return ResponseEntity.noContent().build();
	}
}
