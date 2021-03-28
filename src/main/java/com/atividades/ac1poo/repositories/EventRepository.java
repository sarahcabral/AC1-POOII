package com.atividades.ac1poo.repositories;

import com.atividades.ac1poo.entities.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event,Long> {

    @Query("SELECT e FROM Event e")
    public Page<Event> find(Pageable pageRequest);
}
