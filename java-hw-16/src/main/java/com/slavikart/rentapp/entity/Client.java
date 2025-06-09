package com.slavikart.rentapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fullName;
    private String phone;
    
    @OneToMany(mappedBy = "client")
    private List<Rental> rentals;
} 