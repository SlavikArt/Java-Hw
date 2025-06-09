package com.slavikart.rentapp.controller;

import com.slavikart.rentapp.entity.Client;
import com.slavikart.rentapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    
    @GetMapping("/ending-rentals")
    public List<Client> getClientsWithRentalsEndingInMonth() {
        return clientService.getClientsWithRentalsEndingInMonth();
    }
    
    @GetMapping("/monthly-rentals")
    public List<Client> getClientsWithRentalsInMonth() {
        return clientService.getClientsWithRentalsInMonth();
    }
    
    @GetMapping("/search")
    public List<Client> searchClients(@RequestParam String query) {
        return clientService.searchClients(query);
    }
    
    @GetMapping("/without-rentals")
    public List<Client> getClientsWithoutRentals() {
        return clientService.getClientsWithoutRentals();
    }
    
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }
    
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
} 