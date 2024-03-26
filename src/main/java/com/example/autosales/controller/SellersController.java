package com.example.autosales.controller;

import com.example.autosales.dto.request.SellersRequest;
import com.example.autosales.dto.response.SellersResponseDto;
import com.example.autosales.service.SellersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sellers")
@RequiredArgsConstructor
public class SellersController {
    private final SellersService sellersService;

    @GetMapping
    public List<SellersResponseDto> getAllSellers() {
        return sellersService.getAllSellers();
    }

    @PostMapping
    public ResponseEntity<SellersResponseDto> createSellers(@RequestBody SellersRequest sellersRequest) {
        return new ResponseEntity<>(sellersService.createSellers(sellersRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public SellersResponseDto updateSellers(@PathVariable Integer id, @RequestBody SellersRequest sellersRequest) {
        return sellersService.updateSellers(id, sellersRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteSellersById(@PathVariable Integer id) {
        sellersService.deleteSellers(id);
    }
}
