package com.itstep.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CustomerOrderInfo {
    private Customer customer;
    private Staff staff;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
}
