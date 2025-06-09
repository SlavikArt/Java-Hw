package com.slavikart.rentapp.repository;

import com.slavikart.rentapp.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    @Query("SELECT a FROM Apartment a WHERE NOT EXISTS (SELECT r FROM Rental r WHERE r.apartment = a)")
    List<Apartment> findAvailableApartments();
    
    @Query("SELECT a FROM Apartment a WHERE NOT EXISTS (SELECT r FROM Rental r WHERE r.apartment = a AND r.endDate > ?1)")
    List<Apartment> findApartmentsAvailableAfter(LocalDate date);
    
    @Query("SELECT a FROM Apartment a WHERE a.price BETWEEN ?1 AND ?2")
    List<Apartment> findApartmentsByPriceRange(Double minPrice, Double maxPrice);
    
    @Query("SELECT a FROM Apartment a WHERE NOT EXISTS (SELECT r FROM Rental r WHERE r.apartment = a)")
    List<Apartment> findNeverRentedApartments();
    
    @Query("SELECT COUNT(a) FROM Apartment a WHERE NOT EXISTS (SELECT r FROM Rental r WHERE r.apartment = a)")
    Long countAvailableApartments();
    
    @Query("SELECT COUNT(a) FROM Apartment a WHERE EXISTS (SELECT r FROM Rental r WHERE r.apartment = a)")
    Long countRentedApartments();
} 