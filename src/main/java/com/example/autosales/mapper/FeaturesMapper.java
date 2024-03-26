package com.example.autosales.mapper;

import com.example.autosales.dto.request.CarsRequest;
import com.example.autosales.dto.request.FeaturesRequest;
import com.example.autosales.dto.response.CarsResponseDto;
import com.example.autosales.dto.response.FeaturesResponseDto;
import com.example.autosales.entity.Cars;
import com.example.autosales.entity.Features;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface FeaturesMapper {
    Features fromDTO(FeaturesRequest featuresRequest);

    FeaturesResponseDto toDTO(Features features);

    List<FeaturesResponseDto> toDTOs(List<Features> features);

    Features mapUpdateRequestToEntity(@MappingTarget Features features, FeaturesRequest featuresRequest);
}
