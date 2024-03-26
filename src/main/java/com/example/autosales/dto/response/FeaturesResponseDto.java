package com.example.autosales.dto.response;

import com.example.autosales.dto.CarsResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeaturesResponseDto {
    private Integer featureId;
    private String feature;
    private CarsResponse car;
}
