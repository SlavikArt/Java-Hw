package com.slavikart.eventsapp.service;

import com.slavikart.eventsapp.dto.EventCreationDTO;
import com.slavikart.eventsapp.dto.TicketPackDTO;
import com.slavikart.eventsapp.entity.*;
import com.slavikart.eventsapp.repository.EventRepository;
import com.slavikart.eventsapp.repository.PlaceRepository;
import com.slavikart.eventsapp.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepo;
    private final PlaceRepository placeRepo;
    private final TicketRepository ticketRepo;

    @Transactional
    public Event createEvent(EventCreationDTO dto) {
        Place place = placeRepo.findByName(dto.getPlace().getName());
        if (place == null) {
            place = new Place();
            place.setName(dto.getPlace().getName());
            place.setAddress(dto.getPlace().getAddress());
            place = placeRepo.save(place);
        }

        Event event = new Event();
        event.setName(dto.getName());
        event.setEventDate(dto.getEventDate());
        event.setPlace(place);
        event = eventRepo.save(event);

        int totalTickets = 0;
        for (TicketPackDTO pack : dto.getTicketPacks()) {
            for (int i = 0; i < pack.getCount(); i++) {
                Ticket ticket = new Ticket();
                ticket.setEvent(event);
                ticket.setCost(pack.getCost());
                ticket.setNumber(UUID.randomUUID().toString());
                ticket.setStatus(TicketStatus.FREE);
                ticketRepo.save(ticket);
                totalTickets++;
            }
        }
        
        event.setTotalTickets(totalTickets);
        event.setAvailableTickets(totalTickets);
        return eventRepo.save(event);
    }

    public List<Event> getAvailableEventsByDate(LocalDate date) {
        return eventRepo.findAvailableEventsByDate(date);
    }

    public List<Event> getEventsByOrganizer(String organizer) {
        return eventRepo.findEventsByOrganizer(organizer);
    }

    public List<Event> getEventsByPlace(Long placeId) {
        return eventRepo.findEventsByPlace(placeId);
    }

    public List<Event> getAlmostSoldOutEvents() {
        return eventRepo.findAlmostSoldOutEvents();
    }

    public List<Event> getSoldOutEventsOrderByProfit() {
        return eventRepo.findSoldOutEventsOrderByProfit();
    }
} 