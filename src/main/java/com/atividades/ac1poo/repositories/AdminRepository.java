package com.atividades.ac1poo.repositories;
import com.atividades.ac1poo.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository <Admin, Long>{
    
}
