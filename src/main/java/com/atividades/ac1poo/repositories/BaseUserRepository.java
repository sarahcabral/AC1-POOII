package com.atividades.ac1poo.repositories;
import com.atividades.ac1poo.entities.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserRepository extends JpaRepository <BaseUser, Long>{
}