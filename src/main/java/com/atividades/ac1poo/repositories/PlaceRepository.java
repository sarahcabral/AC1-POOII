package com.atividades.ac1poo.repositories;
import com.atividades.ac1poo.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository <Place, Long>{
    
}
