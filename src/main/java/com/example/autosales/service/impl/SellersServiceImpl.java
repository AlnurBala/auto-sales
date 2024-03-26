package com.example.autosales.service.impl;

import com.example.autosales.dto.request.SellersRequest;
import com.example.autosales.dto.response.SellersResponseDto;
import com.example.autosales.entity.Sellers;
import com.example.autosales.mapper.SellersMapper;
import com.example.autosales.repository.SellersRepository;
import com.example.autosales.service.SellersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellersServiceImpl implements SellersService {
    private final SellersRepository sellersRepository;
    private final SellersMapper sellersMapper;
    @Override
    public List<SellersResponseDto> getAllSellers() {
        var sellersEntities = sellersRepository.findAll();
        return sellersMapper.toDTOs(sellersEntities);
    }

    @Override
    public SellersResponseDto createSellers(SellersRequest sellersRequest) {
        var sellersEntity = sellersMapper.fromDTO(sellersRequest);
        sellersEntity = sellersRepository.save(sellersEntity);
        return sellersMapper.toDTO(sellersEntity);
    }

    @Override
    public SellersResponseDto updateSellers(Integer id, SellersRequest sellersRequest) {
        var newSellers = sellersRepository.findById(id).orElse(new Sellers());
        sellersMapper.mapUpdateRequestToEntity(newSellers, sellersRequest);
        sellersRepository.save(newSellers);
        return sellersMapper.toDTO(newSellers);
    }

    @Override
    public void deleteSellers(Integer id) {
        sellersRepository.deleteById(id);
    }
}
