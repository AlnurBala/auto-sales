package com.example.autosales.dto.response;

import com.example.autosales.dto.CarsResponse;
import com.example.autosales.dto.FeaturesResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellersResponseDto {
    private Integer sellerId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<CarsResponse>cars;
}
