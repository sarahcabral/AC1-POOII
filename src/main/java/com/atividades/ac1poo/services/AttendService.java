package com.atividades.ac1poo.services;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.atividades.ac1poo.repositories.*;
import org.springframework.http.HttpStatus;
import com.atividades.ac1poo.entities.*;
import com.atividades.ac1poo.dtos.*;
import java.util.Optional;

@Service
public class AttendService{      
   
    @Autowired
    private AttendRepository attendRepository;

    public Page<AttendDTO> getAttend(PageRequest pageRequest, String name, String emailContact) {
         
        Page<Attend> list = attendRepository.find(pageRequest, name, emailContact);
        return list.map( e -> new AttendDTO(e));  
    }

    public AttendDTO getAttendById(Long id) {
        Optional<Attend> op = attendRepository.findById(id);
        Attend attend = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found anywhere. It may never have been scheduled"));
        return new AttendDTO(attend);
    } 

    public AttendDTO insert(AttendInsertDTO insertDTO){
        Attend entity = new Attend(insertDTO);
        attendRepository.save(entity);
        return new AttendDTO(entity);
    }

    public AttendDTO update(Long id, AttendUpdateDTO AttendDTO) {
        try{
            Attend entity = attendRepository.getOne(id);
            if(!AttendDTO.getName().isEmpty())       
                entity.setName(AttendDTO.getName());
            if(AttendDTO.getBalance() != null)       
                entity.setBalance(AttendDTO.getBalance());
            return new AttendDTO(entity);
            
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERROR"); 
        }
    }
    
    public void delete(Long id) {
        try{
            Attend Attend = catchAttendById(id);
            attendRepository.delete(Attend);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        }  catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        }
    }
    private Attend catchAttendById(Long id){
        try{
            Attend adm = attendRepository.getOne(id);
            return adm;
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERROR"); 
        }
    }
}