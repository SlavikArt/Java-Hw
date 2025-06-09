package com.itstep.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Customer {
    private Long id;
    private String fullName;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private BigDecimal discountPercent;
    private LocalDateTime createdAt;
}
