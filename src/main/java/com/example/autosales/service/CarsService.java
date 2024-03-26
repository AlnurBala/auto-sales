package com.example.autosales.service;

import com.example.autosales.dto.request.CarsRequest;
import com.example.autosales.dto.response.CarsResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface CarsService {
    Page<CarsResponseDto> getAllCars(Pageable pageable);

    CarsResponseDto createCars(CarsRequest carsRequest);

    CarsResponseDto updateCars(Integer id, CarsRequest carsRequest);

    void deleteCars(Integer id);
    Page<CarsResponseDto> getCarsByFilter(CarsRequest request, Pageable pageable);
    Page<CarsResponseDto> getCarsSortedByUploadDate(Pageable pageable);
    Page<CarsResponseDto> getCarsSortedByLowPrice(Pageable pageable);
    Page<CarsResponseDto> getCarsSortedByHighPrice(Pageable pageable);
    Page<CarsResponseDto> getCarsSortedByMileageAsc(int pageNumber, int pageSize);
    Page<CarsResponseDto> getAllCarsSortedByYearDesc(Pageable pageable);
    void incrementViewCount(Integer carId);
    CarsResponseDto getCarById(Integer id);
}
