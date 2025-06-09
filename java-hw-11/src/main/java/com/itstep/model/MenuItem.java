package com.itstep.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MenuItem {
    private Long id;
    private String nameEn;
    private String nameUa;
    private BigDecimal price;
    private String itemType;
    private LocalDateTime createdAt;
}
