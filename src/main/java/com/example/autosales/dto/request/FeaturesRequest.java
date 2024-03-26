package com.example.autosales.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeaturesRequest {
    private Integer featureId;
    private String feature;
}
