package com.slavikart.rentapp.controller;

import com.slavikart.rentapp.entity.Rental;
import com.slavikart.rentapp.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;
    
    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }
    
    @GetMapping("/ending-this-month")
    public List<Rental> getRentalsEndingInMonth() {
        return rentalService.getRentalsEndingInMonth();
    }
    
    @GetMapping("/this-month")
    public List<Rental> getRentalsInMonth() {
        return rentalService.getRentalsInMonth();
    }
    
    @GetMapping("/apartment/{apartmentId}/active")
    public List<Rental> getActiveRentalsForApartment(@PathVariable Long apartmentId) {
        return rentalService.getActiveRentalsForApartment(apartmentId);
    }
    
    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.saveRental(rental);
    }
    
    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        return rentalService.updateRental(id, rental);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return ResponseEntity.ok().build();
    }
} 