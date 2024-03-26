package com.example.autosales.service;

import com.example.autosales.dto.request.SellersRequest;
import com.example.autosales.dto.response.SellersResponseDto;

import java.util.List;

public interface SellersService {
    List<SellersResponseDto> getAllSellers();

    SellersResponseDto createSellers(SellersRequest sellersRequest);

    SellersResponseDto updateSellers(Integer id, SellersRequest sellersRequest);

    void deleteSellers(Integer id);
}
