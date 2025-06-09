package com.slavikart.eventsapp.repository;

import com.slavikart.eventsapp.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByName(String name);
} 