package com.example.autosales.service.impl;

import com.example.autosales.dto.request.CarsRequest;
import com.example.autosales.dto.response.CarsResponseDto;
import com.example.autosales.entity.Cars;
import com.example.autosales.exception.CarNotFoundException;
import com.example.autosales.mapper.CarsMapper;
import com.example.autosales.repository.CarsCriteria;
import com.example.autosales.repository.CarsRepository;
import com.example.autosales.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarsServiceImpl implements CarsService {
    private final CarsRepository carsRepository;
    private final CarsMapper carsMapper;
    private final CarsCriteria carsCriteria;
    @Override
    public Page<CarsResponseDto> getCarsByFilter(CarsRequest request, Pageable pageable) {
        Page<Cars> carsPage = carsCriteria.getCarsByFilter(request, pageable);
        return carsPage.map(carsMapper::toDTO);
    }
    @Override
    public Page<CarsResponseDto> getCarsSortedByUploadDate(Pageable pageable) {
        Page<Cars> cars = carsRepository.findAllByOrderByUploadDateDesc(pageable);
        return carsMapper.toDTOp(cars);
    }
    @Override
    public Page<CarsResponseDto> getCarsSortedByLowPrice(Pageable pageable) {
        Page<Cars> cars = carsRepository.findAllByOrderByPriceAsc(pageable);
        return carsMapper.toDTOp(cars);
    }

    @Override
    public Page<CarsResponseDto> getCarsSortedByHighPrice(Pageable pageable) {
        Page<Cars> cars = carsRepository.findAllByOrderByPriceDesc(pageable);
        return carsMapper.toDTOp(cars);
    }
    @Override
    public Page<CarsResponseDto> getCarsSortedByMileageAsc(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("mileage").ascending());
        Page<Cars> cars = carsRepository.findAllByOrderByMileageAsc(pageable);
        return carsMapper.toDTOp(cars);
    }
    @Override
    public Page<CarsResponseDto> getAllCarsSortedByYearDesc(Pageable pageable) {
        Page<Cars> cars= carsRepository.findAllByOrderByYearDesc(pageable);
        return carsMapper.toDTOp(cars);
    }
    @Override
    public void incrementViewCount(Integer carId) {
        Cars car = carsRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException(carId));

        // Increment the view count
        car.setViewCount((car.getViewCount() != null ? car.getViewCount() : 0) + 1);

        // Save the updated car entity
        carsRepository.save(car);
    }
    @Override
    public CarsResponseDto getCarById(Integer id) {
        Cars carsEntity = carsRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        return carsMapper.toDTO(carsEntity);
    }
    @Override
    public Page<CarsResponseDto> getAllCars(Pageable pageable) {
        var carsEntities = carsRepository.findAllPageable(pageable);
        return carsMapper.toDTOp(carsEntities);
    }

    @Override
    public CarsResponseDto createCars(CarsRequest carsRequest) {
        var carsEntity = carsMapper.fromDTO(carsRequest);
        carsEntity = carsRepository.save(carsEntity);
        return carsMapper.toDTO(carsEntity);
    }

    @Override
    public CarsResponseDto updateCars(Integer id, CarsRequest carsRequest) {
        var newCars = carsRepository.findById(id).orElse(new Cars());
        carsMapper.mapUpdateRequestToEntity(newCars, carsRequest);
        carsRepository.save(newCars);
        return carsMapper.toDTO(newCars);
    }

    @Override
    public void deleteCars(Integer id) {
        carsRepository.deleteById(id);
    }
}
