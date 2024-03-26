package com.example.autosales.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(Integer carId) {
        super("Car not found with id : " + carId);
    }
}