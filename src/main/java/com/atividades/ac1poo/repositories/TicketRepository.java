package com.atividades.ac1poo.repositories;
import com.atividades.ac1poo.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long>{
}

