package com.slavikart.rentapp.repository;

import com.slavikart.rentapp.entity.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface LandlordRepository extends JpaRepository<Landlord, Long> {
    @Query("SELECT l FROM Landlord l ORDER BY SIZE(l.apartments) DESC")
    List<Landlord> findTop10ByApartmentCount();
    
    @Query("SELECT AVG(SIZE(l.apartments)) FROM Landlord l")
    Double findAverageApartmentCount();
    
    @Query("SELECT AVG(SIZE(l.apartments)) FROM Landlord l WHERE EXISTS (SELECT r FROM Rental r WHERE r.apartment MEMBER OF l.apartments)")
    Double findAverageRentedApartmentCount();
    
    @Query("SELECT l FROM Landlord l WHERE SIZE(l.apartments) = (SELECT MAX(SIZE(l2.apartments)) FROM Landlord l2)")
    List<Landlord> findLandlordsWithMaxApartments();
} 