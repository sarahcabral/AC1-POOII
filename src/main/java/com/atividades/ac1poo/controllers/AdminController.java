package com.atividades.ac1poo.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.atividades.ac1poo.services.AdminService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.atividades.ac1poo.dtos.*;
import java.net.URI;

@RestController
@RequestMapping("/admins")
public class AdminController {
    
    /**
     * ------------
     * @Declaration
     * ------------
     */
    @Autowired
    private AdminService adminService;

    /**
     * _______
     * @ROUTES
     * |||||||
     */
    /*
    @GetMapping
    public ResponseEntity<Page<AdminDTO>> getAdmins(
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
        Page <AdminDTO> list = service.getAdmins(pageRequest, name.trim(), place.trim(), description.trim(), startDate);
        return ResponseEntity.ok().body(list);
    }*/
    
    @GetMapping("{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long id){
        AdminDTO dto = adminService.getAdminById(id);
 
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<AdminDTO> insert (@RequestBody AdminInsertDTO insertDTO) {
        AdminDTO dto = adminService.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<AdminDTO> update(@RequestBody AdminUpdateDTO updateDTO, @PathVariable Long id) {
        AdminDTO dto = adminService.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		adminService.delete(id); 
		return ResponseEntity.noContent().build();
	}
}
