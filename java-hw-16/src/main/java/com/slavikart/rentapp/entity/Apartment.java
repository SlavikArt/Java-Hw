package com.slavikart.rentapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String address;
    private String district;
    private Integer rooms;
    private Double price;
    
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;
    
    @OneToMany(mappedBy = "apartment")
    private List<Rental> rentals;
} 