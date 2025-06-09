package com.itstep.model;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Staff {
    private Long id;
    private String fullName;
    private String phone;
    private String address;
    private String position;
    private LocalDate hireDate;
    private LocalDateTime createdAt;
}
