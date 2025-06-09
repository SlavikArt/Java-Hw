package com.slavikart.eventsapp.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class EventCreationDTO {
    private Long id;
    private LocalDate eventDate;
    private String name;
    private List<TicketPackDTO> ticketPacks;
    private PlaceDTO place;
} 