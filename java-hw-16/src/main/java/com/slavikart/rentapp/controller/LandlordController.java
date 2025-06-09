package com.slavikart.rentapp.controller;

import com.slavikart.rentapp.entity.Landlord;
import com.slavikart.rentapp.service.LandlordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/landlords")
@RequiredArgsConstructor
public class LandlordController {
    private final LandlordService landlordService;
    
    @GetMapping
    public List<Landlord> getAllLandlords() {
        return landlordService.getAllLandlords();
    }
    
    @GetMapping("/top10")
    public List<Landlord> getTop10Landlords() {
        return landlordService.getTop10Landlords();
    }
    
    @GetMapping("/stats/avg-apartments")
    public Double getAverageApartmentCount() {
        return landlordService.getAverageApartmentCount();
    }
    
    @GetMapping("/stats/avg-rented")
    public Double getAverageRentedApartmentCount() {
        return landlordService.getAverageRentedApartmentCount();
    }
    
    @GetMapping("/stats/max-apartments")
    public List<Landlord> getLandlordsWithMaxApartments() {
        return landlordService.getLandlordsWithMaxApartments();
    }
    
    @PostMapping
    public Landlord createLandlord(@RequestBody Landlord landlord) {
        return landlordService.saveLandlord(landlord);
    }
    
    @PutMapping("/{id}")
    public Landlord updateLandlord(@PathVariable Long id, @RequestBody Landlord landlord) {
        return landlordService.updateLandlord(id, landlord);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLandlord(@PathVariable Long id) {
        landlordService.deleteLandlord(id);
        return ResponseEntity.ok().build();
    }
} 