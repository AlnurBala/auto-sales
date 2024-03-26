package com.example.autosales.controller;

import com.example.autosales.dto.request.FeaturesRequest;
import com.example.autosales.dto.response.FeaturesResponseDto;
import com.example.autosales.service.FeaturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/features")
@RequiredArgsConstructor
public class FeaturesController {
    private final FeaturesService featuresService;

    @GetMapping
    public List<FeaturesResponseDto> getAllFeatures() {
        return featuresService.getAllFeatures();
    }

    @PostMapping
    public ResponseEntity<FeaturesResponseDto> createFeatures(@RequestBody FeaturesRequest featuresRequest) {
        return new ResponseEntity<>(featuresService.createFeatures(featuresRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
        public FeaturesResponseDto updateFeatures(@PathVariable Integer id, @RequestBody FeaturesRequest featuresRequest) {
        return featuresService.updateFeatures(id, featuresRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteFeaturesById(@PathVariable Integer id) {
        featuresService.deleteFeatures(id);
    }
}
