package com.example.autosales.dto.response;

import com.example.autosales.dto.FeaturesResponse;
import com.example.autosales.dto.SellersResponse;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarsResponseDto {
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
    private Integer viewCount;
    private List<FeaturesResponse> features;
    private SellersResponse seller;

}
