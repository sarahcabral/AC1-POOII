package com.atividades.ac1poo.repositories;

import com.atividades.ac1poo.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event,Long> {
    
}
