package com.example.autosales.mapper;

import com.example.autosales.dto.request.CarsRequest;
import com.example.autosales.dto.request.SellersRequest;
import com.example.autosales.dto.response.CarsResponseDto;
import com.example.autosales.dto.response.SellersResponseDto;
import com.example.autosales.entity.Cars;
import com.example.autosales.entity.Sellers;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface SellersMapper {
    Sellers fromDTO(SellersRequest sellersRequest);

    SellersResponseDto toDTO(Sellers sellers);

    List<SellersResponseDto> toDTOs(List<Sellers> sellers);

    Sellers mapUpdateRequestToEntity(@MappingTarget Sellers sellers, SellersRequest sellersRequest);
}
