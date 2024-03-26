package com.example.autosales.service.impl;

import com.example.autosales.dto.request.FeaturesRequest;
import com.example.autosales.dto.response.FeaturesResponseDto;
import com.example.autosales.entity.Features;
import com.example.autosales.mapper.FeaturesMapper;
import com.example.autosales.repository.FeaturesRepository;
import com.example.autosales.service.FeaturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeaturesServiceImpl implements FeaturesService {
    private final FeaturesRepository featuresRepository;
    private final FeaturesMapper featuresMapper;
    @Override
    public List<FeaturesResponseDto> getAllFeatures() {
        var featuresEntities = featuresRepository.findAll();
        return featuresMapper.toDTOs(featuresEntities);
    }

    @Override
    public FeaturesResponseDto createFeatures(FeaturesRequest featuresRequest) {
        var featuresEntity = featuresMapper.fromDTO(featuresRequest);
        featuresEntity = featuresRepository.save(featuresEntity);
        return featuresMapper.toDTO(featuresEntity);
    }

    @Override
    public FeaturesResponseDto updateFeatures(Integer id, FeaturesRequest featuresRequest) {
        var newFeatures = featuresRepository.findById(id).orElse(new Features());
        featuresMapper.mapUpdateRequestToEntity(newFeatures, featuresRequest);
        featuresRepository.save(newFeatures);
        return featuresMapper.toDTO(newFeatures);
    }

    @Override
    public void deleteFeatures(Integer id) {
        featuresRepository.deleteById(id);
    }
}
