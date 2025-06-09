package com.slavikart.rentapp.service;

import com.slavikart.rentapp.entity.Apartment;
import com.slavikart.rentapp.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepo;
    
    public List<Apartment> getAvailableApartments() {
        return apartmentRepo.findAvailableApartments();
    }
    
    public List<Apartment> getApartmentsByPriceRange(Double minPrice, Double maxPrice) {
        return apartmentRepo.findApartmentsByPriceRange(minPrice, maxPrice);
    }
    
    public List<Apartment> getApartmentsAvailableAfter(LocalDate date) {
        return apartmentRepo.findApartmentsAvailableAfter(date);
    }
    
    public List<Apartment> getNeverRentedApartments() {
        return apartmentRepo.findNeverRentedApartments();
    }
    
    public Long getAvailableApartmentsCount() {
        return apartmentRepo.countAvailableApartments();
    }
    
    public Long getRentedApartmentsCount() {
        return apartmentRepo.countRentedApartments();
    }
    
    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepo.save(apartment);
    }
    
    public void deleteApartment(Long id) {
        apartmentRepo.deleteById(id);
    }
    
    public Apartment updateApartment(Long id, Apartment apartment) {
        apartment.setId(id);
        return apartmentRepo.save(apartment);
    }
} 