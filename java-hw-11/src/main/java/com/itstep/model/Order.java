package com.itstep.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long id;
    private Long customerId;
    private Long staffId;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
}
