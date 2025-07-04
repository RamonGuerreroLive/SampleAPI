package com.example.sampleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Car model")
public class Car {
    @Schema(description = "Unique identifier for the car", example = "1")
    private Long id;

    @Schema(description = "Brand of the car", example = "Toyota")
    private String brand;

    @Schema(description = "Model of the car", example = "Camry")
    private String model;

    @Schema(description = "Year of manufacture", example = "2023")
    private Integer year;

    @Schema(description = "Color of the car", example = "Red")
    private String color;

    @Schema(description = "Engine capacity in liters", example = "2.5")
    private Double engineCapacity;

    @Schema(description = "Fuel type", example = "Gasoline")
    private String fuelType;

    @Schema(description = "Price in USD", example = "25000.00")
    private Double price;

    @Schema(description = "Number of doors", example = "4")
    private Integer doors;

    @Schema(description = "Transmission type", example = "Automatic")
    private String transmission;

    @Schema(description = "Mileage in kilometers", example = "15000")
    private Integer mileage;

    public Car() {
    }

    public Car(Long id, String brand, String model, Integer year, String color,
            Double engineCapacity, String fuelType, Double price, Integer doors,
            String transmission, Integer mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
        this.price = price;
        this.doors = doors;
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

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
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

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
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