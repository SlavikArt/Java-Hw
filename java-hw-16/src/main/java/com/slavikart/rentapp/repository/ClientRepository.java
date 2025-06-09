package com.slavikart.rentapp.repository;

import com.slavikart.rentapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByFullNameContainingOrPhoneContaining(String fullName, String phone);
    
    @Query("SELECT c FROM Client c JOIN c.rentals r WHERE r.endDate BETWEEN ?1 AND ?2")
    List<Client> findClientsWithRentalsEndingInPeriod(LocalDate start, LocalDate end);
    
    @Query("SELECT c FROM Client c JOIN c.rentals r WHERE r.startDate BETWEEN ?1 AND ?2")
    List<Client> findClientsWithRentalsInPeriod(LocalDate start, LocalDate end);
    
    @Query("SELECT c FROM Client c WHERE NOT EXISTS (SELECT r FROM Rental r WHERE r.client = c)")
    List<Client> findClientsWithoutRentals();
} 