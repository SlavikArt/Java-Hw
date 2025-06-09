package com.slavikart.rentapp.service;

import com.slavikart.rentapp.entity.Rental;
import com.slavikart.rentapp.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepo;
    
    public List<Rental> getAllRentals() {
        return rentalRepo.findAll();
    }
    
    public List<Rental> getRentalsEndingInMonth() {
        LocalDate now = LocalDate.now();
        LocalDate monthLater = now.plusMonths(1);
        return rentalRepo.findRentalsEndingInPeriod(now, monthLater);
    }
    
    public List<Rental> getRentalsInMonth() {
        LocalDate now = LocalDate.now();
        LocalDate monthLater = now.plusMonths(1);
        return rentalRepo.findRentalsInPeriod(now, monthLater);
    }
    
    public List<Rental> getActiveRentalsForApartment(Long apartmentId) {
        return rentalRepo.findActiveRentalsForApartment(apartmentId, LocalDate.now());
    }
    
    public Rental saveRental(Rental rental) {
        return rentalRepo.save(rental);
    }
    
    public void deleteRental(Long id) {
        rentalRepo.deleteById(id);
    }
    
    public Rental updateRental(Long id, Rental rental) {
        rental.setId(id);
        return rentalRepo.save(rental);
    }
} 