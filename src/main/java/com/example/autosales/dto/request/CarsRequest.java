package com.example.autosales.dto.request;

import com.example.autosales.annotation.ValidBrandAndModel;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ValidBrandAndModel
public class CarsRequest {
    private Integer carId;
    private String city;
    private String brand;
    private String model;
    private Integer minYear;
    private Integer maxYear;
    private String ban;
    private String mileage;
    private String color;
    private String engine;
    private String gearBox;
    private String gear;
    private String carIsNew;
    private Integer seats;
    private Integer owners;
    private String condition;
    private String market;
    private Integer minPrice;
    private Integer maxPrice;
    private Date uploadDate;
}
