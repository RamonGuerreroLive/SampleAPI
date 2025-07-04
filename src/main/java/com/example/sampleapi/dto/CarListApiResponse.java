package com.example.sampleapi.dto;

import com.example.sampleapi.model.Car;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "CarListApiResponse", description = "API response containing a list of cars")
public class CarListApiResponse extends ApiResponse<List<Car>> {
    public CarListApiResponse() {
        super();
    }
}