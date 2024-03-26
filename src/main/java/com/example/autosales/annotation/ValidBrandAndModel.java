package com.example.autosales.annotation;

import com.example.autosales.util.BrandAndModelValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {BrandAndModelValidator.class})
public @interface ValidBrandAndModel {
    String message() default "Filtering by model can only be selected if filtering by brand is also selected";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
