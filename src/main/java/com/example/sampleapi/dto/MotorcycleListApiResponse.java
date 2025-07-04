package com.example.sampleapi.dto;

import com.example.sampleapi.model.Motorcycle;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "MotorcycleListApiResponse", description = "API response containing a list of motorcycles")
public class MotorcycleListApiResponse extends ApiResponse<List<Motorcycle>> {
    public MotorcycleListApiResponse() {
        super();
    }
}