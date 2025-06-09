package com.slavikart.eventsapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String organizer;
    private LocalDate eventDate;
    private LocalTime startTime;
    private Integer duration;
    private Integer totalTickets;
    private Integer availableTickets;
    private Double ticketPrice;
    
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
} 