package com.slavikart.rentapp.service;

import com.slavikart.rentapp.entity.Landlord;
import com.slavikart.rentapp.repository.LandlordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LandlordService {
    private final LandlordRepository landlordRepo;
    
    public List<Landlord> getAllLandlords() {
        return landlordRepo.findAll();
    }
    
    public List<Landlord> getTop10Landlords() {
        return landlordRepo.findTop10ByApartmentCount();
    }
    
    public Double getAverageApartmentCount() {
        return landlordRepo.findAverageApartmentCount();
    }
    
    public Double getAverageRentedApartmentCount() {
        return landlordRepo.findAverageRentedApartmentCount();
    }
    
    public List<Landlord> getLandlordsWithMaxApartments() {
        return landlordRepo.findLandlordsWithMaxApartments();
    }
    
    public Landlord saveLandlord(Landlord landlord) {
        return landlordRepo.save(landlord);
    }
    
    public void deleteLandlord(Long id) {
        landlordRepo.deleteById(id);
    }
    
    public Landlord updateLandlord(Long id, Landlord landlord) {
        landlord.setId(id);
        return landlordRepo.save(landlord);
    }
} 