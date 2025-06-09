package com.slavikart.eventsapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double cost;
    private String number;
    
    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.FREE;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
} 