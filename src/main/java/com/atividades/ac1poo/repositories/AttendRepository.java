package com.atividades.ac1poo.repositories;
import com.atividades.ac1poo.entities.Attend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendRepository extends JpaRepository <Attend, Long>{
}