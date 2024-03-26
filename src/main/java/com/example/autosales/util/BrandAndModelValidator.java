package com.example.autosales.util;

import com.example.autosales.annotation.ValidBrandAndModel;
import com.example.autosales.dto.request.CarsRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BrandAndModelValidator implements ConstraintValidator<ValidBrandAndModel, CarsRequest> {
    @Override
    public void initialize(ValidBrandAndModel constraintAnnotation) {
    }

    @Override
    public boolean isValid(CarsRequest request, ConstraintValidatorContext context) {
        // Check if filtering by model is selected without filtering by brand
        return !(request.getModel() != null && request.getBrand() == null);
    }
}
