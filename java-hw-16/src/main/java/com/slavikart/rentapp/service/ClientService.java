package com.slavikart.rentapp.service;

import com.slavikart.rentapp.entity.Client;
import com.slavikart.rentapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepo;
    
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }
    
    public List<Client> getClientsWithRentalsEndingInMonth() {
        LocalDate now = LocalDate.now();
        LocalDate monthLater = now.plusMonths(1);
        return clientRepo.findClientsWithRentalsEndingInPeriod(now, monthLater);
    }
    
    public List<Client> getClientsWithRentalsInMonth() {
        LocalDate now = LocalDate.now();
        LocalDate monthLater = now.plusMonths(1);
        return clientRepo.findClientsWithRentalsInPeriod(now, monthLater);
    }
    
    public List<Client> searchClients(String query) {
        return clientRepo.findByFullNameContainingOrPhoneContaining(query, query);
    }
    
    public List<Client> getClientsWithoutRentals() {
        return clientRepo.findClientsWithoutRentals();
    }
    
    public Client saveClient(Client client) {
        return clientRepo.save(client);
    }
    
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
    
    public Client updateClient(Long id, Client client) {
        client.setId(id);
        return clientRepo.save(client);
    }
} 