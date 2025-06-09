package com.slavikart.eventsapp.controller;

import com.slavikart.eventsapp.dto.EventCreationDTO;
import com.slavikart.eventsapp.entity.Event;
import com.slavikart.eventsapp.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventCreationDTO dto) {
        return ResponseEntity.ok(eventService.createEvent(dto));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Event>> getAvailableEventsByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(eventService.getAvailableEventsByDate(date));
    }

    @GetMapping("/organizer/{organizer}")
    public ResponseEntity<List<Event>> getEventsByOrganizer(@PathVariable String organizer) {
        return ResponseEntity.ok(eventService.getEventsByOrganizer(organizer));
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Event>> getEventsByPlace(@PathVariable Long placeId) {
        return ResponseEntity.ok(eventService.getEventsByPlace(placeId));
    }

    @GetMapping("/almost-sold-out")
    public ResponseEntity<List<Event>> getAlmostSoldOutEvents() {
        return ResponseEntity.ok(eventService.getAlmostSoldOutEvents());
    }

    @GetMapping("/sold-out")
    public ResponseEntity<List<Event>> getSoldOutEventsOrderByProfit() {
        return ResponseEntity.ok(eventService.getSoldOutEventsOrderByProfit());
    }
} 