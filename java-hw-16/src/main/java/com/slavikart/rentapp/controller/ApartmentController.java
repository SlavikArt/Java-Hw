package com.slavikart.rentapp.controller;

import com.slavikart.rentapp.entity.Apartment;
import com.slavikart.rentapp.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/apartments")
@RequiredArgsConstructor
public class ApartmentController {
    private final ApartmentService apartmentService;
    
    @GetMapping
    public List<Apartment> getAllApartments() {
        return apartmentService.getAvailableApartments();
    }
    
    @GetMapping("/available")
    public List<Apartment> getAvailableApartments() {
        return apartmentService.getAvailableApartments();
    }
    
    @GetMapping("/price-range")
    public List<Apartment> getApartmentsByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        return apartmentService.getApartmentsByPriceRange(minPrice, maxPrice);
    }
    
    @GetMapping("/available-after")
    public List<Apartment> getApartmentsAvailableAfter(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return apartmentService.getApartmentsAvailableAfter(date);
    }
    
    @GetMapping("/never-rented")
    public List<Apartment> getNeverRentedApartments() {
        return apartmentService.getNeverRentedApartments();
    }
    
    @GetMapping("/stats/available-count")
    public Long getAvailableApartmentsCount() {
        return apartmentService.getAvailableApartmentsCount();
    }
    
    @GetMapping("/stats/rented-count")
    public Long getRentedApartmentsCount() {
        return apartmentService.getRentedApartmentsCount();
    }
    
    @PostMapping
    public Apartment createApartment(@RequestBody Apartment apartment) {
        return apartmentService.saveApartment(apartment);
    }
    
    @PutMapping("/{id}")
    public Apartment updateApartment(@PathVariable Long id, @RequestBody Apartment apartment) {
        return apartmentService.updateApartment(id, apartment);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id) {
        apartmentService.deleteApartment(id);
        return ResponseEntity.ok().build();
    }
} 