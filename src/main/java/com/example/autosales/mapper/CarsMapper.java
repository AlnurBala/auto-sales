package com.example.autosales.mapper;

import com.example.autosales.dto.request.CarsRequest;
import com.example.autosales.dto.response.CarsResponseDto;
import com.example.autosales.entity.Cars;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface CarsMapper {
    Cars fromDTO(CarsRequest carsRequest);

    CarsResponseDto toDTO(Cars cars);

    List<CarsResponseDto> toDTOs(List<Cars> cars);

    Cars mapUpdateRequestToEntity(@MappingTarget Cars cars, CarsRequest carsRequest);
    default Page<CarsResponseDto> toDTOp(Page<Cars> cars) {
        List<CarsResponseDto> carsResponseDtos = cars
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(carsResponseDtos, cars.getPageable(), cars.getTotalElements());
    }
}
