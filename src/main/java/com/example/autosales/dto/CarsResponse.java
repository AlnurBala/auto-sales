package com.example.autosales.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarsResponse {
    private Integer carId;
    private String city;
    private String brand;
    private String model;
    private Integer year;
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
    private Integer price;
    private Date uploadDate;
}
