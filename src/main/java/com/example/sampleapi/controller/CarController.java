package com.example.sampleapi.controller;

import com.example.sampleapi.dto.ApiResponse;
import com.example.sampleapi.dto.CustomResponse;
import com.example.sampleapi.model.Car;
import com.example.sampleapi.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cars")
@Tag(name = "Car Management", description = "APIs for managing cars")
public class CarController {

        @Autowired
        private CarService carService;

        @GetMapping
        @Operation(summary = "Get all cars", description = "Retrieve a list of all available cars", responses = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved cars", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.example.sampleapi.dto.CarListApiResponse.class)))
        })
        public ResponseEntity<ApiResponse<List<Car>>> getAllCars() {
                List<Car> cars = carService.getAllCars();
                ApiResponse<List<Car>> response = new ApiResponse<>(true, cars);
                return ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        @Operation(summary = "Get car by ID", description = "Retrieve a specific car by its ID")
        @ApiResponses(value = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved car", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Car not found"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
        })
        public ResponseEntity<ApiResponse<Car>> getCarById(
                        @Parameter(description = "ID of the car to retrieve", required = true) @PathVariable Long id) {
                return carService.getCarById(id)
                                .map(car -> ResponseEntity.ok(new ApiResponse<>(true, car)))
                                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                .body(new ApiResponse<>(false, null)));
        }

        @PostMapping
        @Operation(summary = "Create a new car", description = "Create a new car with the provided details")
        @ApiResponses(value = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Car created successfully", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input data"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
        })
        public ResponseEntity<ApiResponse<Car>> createCar(
                        @Parameter(description = "Car object to create", required = true) @RequestBody Car car) {
                Car createdCar = carService.createCar(car);
                ApiResponse<Car> response = new ApiResponse<>(true, createdCar);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @PutMapping("/{id}")
        @Operation(summary = "Update car by ID", description = "Update an existing car with the provided details")
        @ApiResponses(value = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Car updated successfully", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Car not found"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input data"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
        })
        public ResponseEntity<ApiResponse<Car>> updateCar(
                        @Parameter(description = "ID of the car to update", required = true) @PathVariable Long id,
                        @Parameter(description = "Updated car object", required = true) @RequestBody Car carDetails) {
                return carService.updateCar(id, carDetails)
                                .map(updatedCar -> ResponseEntity.ok(new ApiResponse<>(true, updatedCar)))
                                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                .body(new ApiResponse<>(false, null)));
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Delete car by ID", description = "Delete a specific car by its ID")
        @ApiResponses(value = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Car deleted successfully"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Car not found"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
        })
        public ResponseEntity<ApiResponse<String>> deleteCar(
                        @Parameter(description = "ID of the car to delete", required = true) @PathVariable Long id) {
                boolean deleted = carService.deleteCar(id);
                if (deleted) {
                        return ResponseEntity.ok(new ApiResponse<>(true, "Car deleted successfully"));
                } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                        .body(new ApiResponse<>(false, "Car not found"));
                }
        }

        @GetMapping("/brand/{brand}")
        @Operation(summary = "Get cars by brand", description = "Retrieve all cars of a specific brand", responses = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved cars by brand", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.example.sampleapi.dto.CarListApiResponse.class)))
        })
        public ResponseEntity<ApiResponse<List<Car>>> getCarsByBrand(
                        @Parameter(description = "Brand name to filter by", required = true) @PathVariable String brand) {
                List<Car> cars = carService.getCarsByBrand(brand);
                ApiResponse<List<Car>> response = new ApiResponse<>(true, cars);
                return ResponseEntity.ok(response);
        }

        @GetMapping("/year/{year}")
        @Operation(summary = "Get cars by year", description = "Retrieve all cars from a specific year", responses = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved cars by year", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.example.sampleapi.dto.CarListApiResponse.class)))
        })
        public ResponseEntity<ApiResponse<List<Car>>> getCarsByYear(
                        @Parameter(description = "Year to filter by", required = true) @PathVariable Integer year) {
                List<Car> cars = carService.getCarsByYear(year);
                ApiResponse<List<Car>> response = new ApiResponse<>(true, cars);
                return ResponseEntity.ok(response);
        }

        @GetMapping("/custom/{id}")
        @Operation(summary = "Get car with custom response", description = "Retrieve a car with custom response format")
        public ResponseEntity<CustomResponse<Car>> getCarWithCustomResponse(
                        @Parameter(description = "ID of the car to retrieve", required = true) @PathVariable Long id) {
                return carService.getCarById(id)
                                .map(car -> {
                                        Map<String, Object> headers = new HashMap<>();
                                        headers.put("X-Custom-Header", "Car-Data");
                                        headers.put("X-Total-Count", carService.getAllCars().size());
                                        return ResponseEntity.ok(new CustomResponse<>(200, headers, car));
                                })
                                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                .body(new CustomResponse<>(404, new HashMap<>(), null)));
        }
}