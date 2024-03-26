package com.example.autosales.service;

import com.example.autosales.dto.request.FeaturesRequest;
import com.example.autosales.dto.response.FeaturesResponseDto;

import java.util.List;

public interface FeaturesService {
    List<FeaturesResponseDto> getAllFeatures();

    FeaturesResponseDto createFeatures(FeaturesRequest featuresRequest);

    FeaturesResponseDto updateFeatures(Integer id, FeaturesRequest featuresRequest);

    void deleteFeatures(Integer id);
}
