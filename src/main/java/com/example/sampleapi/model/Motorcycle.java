package com.example.sampleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Motorcycle model")
public class Motorcycle {
    @Schema(description = "Unique identifier for the motorcycle", example = "1")
    private Long id;

    @Schema(description = "Brand of the motorcycle", example = "Honda")
    private String brand;

    @Schema(description = "Model of the motorcycle", example = "CBR600RR")
    private String model;

    @Schema(description = "Year of manufacture", example = "2023")
    private Integer year;

    @Schema(description = "Color of the motorcycle", example = "Black")
    private String color;

    @Schema(description = "Engine capacity in cubic centimeters", example = "600")
    private Integer engineCapacity;

    @Schema(description = "Fuel type", example = "Gasoline")
    private String fuelType;

    @Schema(description = "Price in USD", example = "12000.00")
    private Double price;

    @Schema(description = "Motorcycle type", example = "Sport")
    private String type;

    @Schema(description = "Transmission type", example = "Manual")
    private String transmission;

    @Schema(description = "Mileage in kilometers", example = "8000")
    private Integer mileage;

    public Motorcycle() {
    }

    public Motorcycle(Long id, String brand, String model, Integer year, String color,
            Integer engineCapacity, String fuelType, Double price, String type,
            String transmission, Integer mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
        this.price = price;
        this.type = type;
        this.transmission = transmission;
        this.mileage = mileage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}