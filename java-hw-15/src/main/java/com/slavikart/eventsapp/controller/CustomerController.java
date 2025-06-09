package com.slavikart.eventsapp.controller;

import com.slavikart.eventsapp.entity.Customer;
import com.slavikart.eventsapp.entity.Ticket;
import com.slavikart.eventsapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone) {
        return ResponseEntity.ok(customerService.createCustomer(name, email, phone));
    }

    @PostMapping("/{customerId}/tickets/{ticketId}/purchase")
    public ResponseEntity<Ticket> purchaseTicket(
            @PathVariable Long customerId,
            @PathVariable Long ticketId) {
        return ResponseEntity.ok(customerService.purchaseTicket(customerId, ticketId));
    }
} 