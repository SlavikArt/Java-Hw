package com.slavikart.rentapp.repository;

import com.slavikart.rentapp.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    @Query("SELECT r FROM Rental r WHERE r.endDate BETWEEN ?1 AND ?2")
    List<Rental> findRentalsEndingInPeriod(LocalDate start, LocalDate end);
    
    @Query("SELECT r FROM Rental r WHERE r.startDate BETWEEN ?1 AND ?2")
    List<Rental> findRentalsInPeriod(LocalDate start, LocalDate end);
    
    @Query("SELECT r FROM Rental r WHERE r.apartment.id = ?1 AND r.endDate > ?2")
    List<Rental> findActiveRentalsForApartment(Long apartmentId, LocalDate date);
} 