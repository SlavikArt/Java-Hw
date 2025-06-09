package com.slavikart.eventsapp.repository;

import com.slavikart.eventsapp.entity.Ticket;
import com.slavikart.eventsapp.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByEventIdAndStatus(Long eventId, TicketStatus status);
} 