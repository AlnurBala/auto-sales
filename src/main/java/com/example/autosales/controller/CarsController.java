package com.example.autosales.controller;

import com.example.autosales.annotation.ValidBrandAndModel;
import com.example.autosales.dto.request.CarsRequest;
import com.example.autosales.dto.response.CarsResponseDto;
import com.example.autosales.entity.Cars;
import com.example.autosales.repository.CarsCriteria;
import com.example.autosales.service.CarsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarsController {
    private final CarsService carsService;
    @GetMapping("/filter")
    public ResponseEntity<Page<CarsResponseDto>> getCarsByFilter(@Valid CarsRequest request,
                                                                 @RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CarsResponseDto> filteredCars = carsService.getCarsByFilter(request, pageable);
        return ResponseEntity.ok(filteredCars);
    }
    @GetMapping("/upload-date")
    public Page<CarsResponseDto> getCarsSortedByUploadDate(Pageable pageable) {
        return carsService.getCarsSortedByUploadDate(pageable);
    }

    @GetMapping("/low-price")
    public Page<CarsResponseDto> getCarsSortedByLowPrice(Pageable pageable) {
        return carsService.getCarsSortedByLowPrice(pageable);
    }

    @GetMapping("/high-price")
    public Page<CarsResponseDto> getCarsSortedByHighPrice(Pageable pageable) {
        return carsService.getCarsSortedByHighPrice(pageable);
    }
    @GetMapping("/mileage")
    public ResponseEntity<Page<CarsResponseDto>> getCarsSortedByMileageAsc(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<CarsResponseDto> cars = carsService.getCarsSortedByMileageAsc(pageNumber, pageSize);
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/year")
    public Page<CarsResponseDto> getAllCarsSortedByYearDesc(Pageable pageable) {
        return carsService.getAllCarsSortedByYearDesc(pageable);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarsResponseDto> getCarById(@PathVariable Integer id) {
        carsService.incrementViewCount(id);
        return ResponseEntity.ok(carsService.getCarById(id));
    }

    @GetMapping
    public Page<CarsResponseDto> getAllCars(Pageable pageable) {
        return carsService.getAllCars(pageable);
    }

    @PostMapping
    public ResponseEntity<CarsResponseDto> createCategory(@RequestBody CarsRequest carsRequest) {
        return new ResponseEntity<>(carsService.createCars(carsRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public CarsResponseDto updateCategory(@PathVariable Integer id, @RequestBody CarsRequest carsRequest) {
        return carsService.updateCars(id, carsRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteCarsById(@PathVariable Integer id) {
        carsService.deleteCars(id);
    }
}
