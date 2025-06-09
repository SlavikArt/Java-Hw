package com.slavikart.rentapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "landlords")
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fullName;
    private String phone;
    
    @OneToMany(mappedBy = "landlord")
    private List<Apartment> apartments;
} 