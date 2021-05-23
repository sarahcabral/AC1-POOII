package com.atividades.ac1poo.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.atividades.ac1poo.services.PlaceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.atividades.ac1poo.dtos.*;
import java.net.URI;

@RestController
@RequestMapping("/places")
public class PlaceController {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Autowired
    private PlaceService placeService;

    /**
     * _______
     * @ROUTES
     * |||||||
     */
    /*
    @GetMapping
    public ResponseEntity<Page<PlaceDTO>> getPlaces(
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
        Page <PlaceDTO> list = service.getPlaces(pageRequest, name.trim(), place.trim(), description.trim(), startDate);
        return ResponseEntity.ok().body(list);
    }*/
    
    @GetMapping("{id}")
    public ResponseEntity<PlaceDTO> getPlaceById(@PathVariable Long id){
        PlaceDTO dto = placeService.getPlaceById(id);
 
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<PlaceDTO> insert (@RequestBody PlaceInsertDTO insertDTO) {
        PlaceDTO dto = placeService.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PlaceDTO> update(@RequestBody PlaceUpdateDTO updateDTO, @PathVariable Long id) {
        PlaceDTO dto = placeService.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		placeService.delete(id); 
		return ResponseEntity.noContent().build();
	}
}
