package com.slavikart.eventsapp.service;

import com.slavikart.eventsapp.entity.Customer;
import com.slavikart.eventsapp.entity.Ticket;
import com.slavikart.eventsapp.entity.TicketStatus;
import com.slavikart.eventsapp.repository.CustomerRepository;
import com.slavikart.eventsapp.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepo;
    private final TicketRepository ticketRepo;

    @Transactional
    public Customer createCustomer(String name, String email, String phone) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        return customerRepo.save(customer);
    }

    @Transactional
    public Ticket purchaseTicket(Long customerId, Long ticketId) {
        Customer customer = customerRepo.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
        
        Ticket ticket = ticketRepo.findById(ticketId)
            .orElseThrow(() -> new RuntimeException("Ticket not found"));
            
        if (ticket.getStatus() != TicketStatus.FREE)
            throw new RuntimeException("Ticket is not available");
            
        ticket.setCustomer(customer);
        ticket.setStatus(TicketStatus.SOLD);
        return ticketRepo.save(ticket);
    }
} 