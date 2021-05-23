package com.atividades.ac1poo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

import com.atividades.ac1poo.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long>{
    @Query("SELECT e FROM Event e " + 
    "WHERE " +
    " LOWER(e.name)               LIKE   LOWER(CONCAT('%', :name, '%')) AND " +
    " LOWER(e.description)        LIKE   LOWER(CONCAT('%', :description, '%')) AND " +
    " e.startDate                  >     :startDate                       AND " +
    " LOWER(e.emailContact)      LIKE   LOWER(CONCAT('%', :emailContact, '%'))")

 public Page<Event> find(Pageable pageRequest, 
                         String name,
                         String description,
                         String emailContact,
                         LocalDate startDate
                         );

    @Query("SELECT e FROM Event e " + 
    "WHERE " +
    " LOWER(e.name)               LIKE   LOWER(CONCAT('%', :name, '%')) AND " +
    " LOWER(e.description)        LIKE   LOWER(CONCAT('%', :description, '%')) AND " +
    " LOWER(e.emailContact)      LIKE   LOWER(CONCAT('%', :emailContact, '%'))")

 public Page<Event> find(Pageable pageRequest, 
                         String name,
                         String description,
                         String emailContact
                         );
}
