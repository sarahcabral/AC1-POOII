package com.atividades.ac1poo.repositories;
import com.atividades.ac1poo.entities.Place;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository <Place, Long>{
    @Query("SELECT p FROM Place p " + 
    "WHERE " +
    " LOWER(p.name)               LIKE   LOWER(CONCAT('%', :name, '%')) AND " +
    " LOWER(p.address)            LIKE   LOWER(CONCAT('%', :address, '%'))")
    public Page<Place> find(Pageable pageRequest, String name, String address);
}
