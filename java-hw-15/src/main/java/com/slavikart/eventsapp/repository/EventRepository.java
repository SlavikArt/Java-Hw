package com.slavikart.eventsapp.repository;

import com.slavikart.eventsapp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.eventDate = :date AND e.availableTickets > 0")
    List<Event> findAvailableEventsByDate(@Param("date") LocalDate date);
    
    @Query("SELECT e FROM Event e WHERE e.organizer = :organizer")
    List<Event> findEventsByOrganizer(@Param("organizer") String organizer);
    
    @Query("SELECT e FROM Event e WHERE e.place.id = :placeId")
    List<Event> findEventsByPlace(@Param("placeId") Long placeId);
    
    @Query("SELECT e FROM Event e WHERE e.availableTickets <= e.totalTickets * 0.1")
    List<Event> findAlmostSoldOutEvents();
    
    @Query("SELECT e FROM Event e WHERE e.availableTickets = 0 ORDER BY (e.totalTickets - e.availableTickets) * e.ticketPrice DESC")
    List<Event> findSoldOutEventsOrderByProfit();
} 