package com.example.API_TEST.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class TechnicianDto {
    private String name;
    private Double changePerHour;
    private String imageName;
    private int ratings;
    private String location;
    private String contact;
}
