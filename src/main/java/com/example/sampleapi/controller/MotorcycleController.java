package com.example.sampleapi.controller;

import com.example.sampleapi.dto.ApiResponse;
import com.example.sampleapi.dto.CustomResponse;
import com.example.sampleapi.model.Motorcycle;
import com.example.sampleapi.service.MotorcycleService;
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
@RequestMapping("/api/motorcycles")
@Tag(name = "Motorcycle Management", description = "APIs for managing motorcycles")
public class MotorcycleController {

        @Autowired
        private MotorcycleService motorcycleService;

        @GetMapping
        @Operation(summary = "Get all motorcycles", description = "Retrieve a list of all available motorcycles", responses = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved motorcycles", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.example.sampleapi.dto.MotorcycleListApiResponse.class)))
        })
        public ResponseEntity<ApiResponse<List<Motorcycle>>> getAllMotorcycles() {
                List<Motorcycle> motorcycles = motorcycleService.getAllMotorcycles();
                ApiResponse<List<Motorcycle>> response = new ApiResponse<>(true, motorcycles);
                return ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        @Operation(summary = "Get motorcycle by ID", description = "Retrieve a specific motorcycle by its ID")
        @ApiResponses(value = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved motorcycle", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Motorcycle not found"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
        })
        public ResponseEntity<ApiResponse<Motorcycle>> getMotorcycleById(
                        @Parameter(description = "ID of the motorcycle to retrieve", required = true) @PathVariable Long id) {
                return motorcycleService.getMotorcycleById(id)
                                .map(motorcycle -> ResponseEntity.ok(new ApiResponse<>(true, motorcycle)))
                                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                .body(new ApiResponse<>(false, null)));
        }

        @PostMapping
        @Operation(summary = "Create a new motorcycle", description = "Create a new motorcycle with the provided details")
        @ApiResponses(value = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Motorcycle created successfully", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input data"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
        })
        public ResponseEntity<ApiResponse<Motorcycle>> createMotorcycle(
                        @Parameter(description = "Motorcycle object to create", required = true) @RequestBody Motorcycle motorcycle) {
                Motorcycle createdMotorcycle = motorcycleService.createMotorcycle(motorcycle);
                ApiResponse<Motorcycle> response = new ApiResponse<>(true, createdMotorcycle);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @PutMapping("/{id}")
        @Operation(summary = "Update motorcycle by ID", description = "Update an existing motorcycle with the provided details")
        @ApiResponses(value = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Motorcycle updated successfully", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Motorcycle not found"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input data"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
        })
        public ResponseEntity<ApiResponse<Motorcycle>> updateMotorcycle(
                        @Parameter(description = "ID of the motorcycle to update", required = true) @PathVariable Long id,
                        @Parameter(description = "Updated motorcycle object", required = true) @RequestBody Motorcycle motorcycleDetails) {
                return motorcycleService.updateMotorcycle(id, motorcycleDetails)
                                .map(updatedMotorcycle -> ResponseEntity.ok(new ApiResponse<>(true, updatedMotorcycle)))
                                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                .body(new ApiResponse<>(false, null)));
        }

        @DeleteMapping("/{id}")
        @Operation(summary = "Delete motorcycle by ID", description = "Delete a specific motorcycle by its ID")
        @ApiResponses(value = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Motorcycle deleted successfully"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Motorcycle not found"),
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
        })
        public ResponseEntity<ApiResponse<String>> deleteMotorcycle(
                        @Parameter(description = "ID of the motorcycle to delete", required = true) @PathVariable Long id) {
                boolean deleted = motorcycleService.deleteMotorcycle(id);
                if (deleted) {
                        return ResponseEntity.ok(new ApiResponse<>(true, "Motorcycle deleted successfully"));
                } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                        .body(new ApiResponse<>(false, "Motorcycle not found"));
                }
        }

        @GetMapping("/brand/{brand}")
        @Operation(summary = "Get motorcycles by brand", description = "Retrieve all motorcycles of a specific brand", responses = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved motorcycles by brand", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.example.sampleapi.dto.MotorcycleListApiResponse.class)))
        })
        public ResponseEntity<ApiResponse<List<Motorcycle>>> getMotorcyclesByBrand(
                        @Parameter(description = "Brand name to filter by", required = true) @PathVariable String brand) {
                List<Motorcycle> motorcycles = motorcycleService.getMotorcyclesByBrand(brand);
                ApiResponse<List<Motorcycle>> response = new ApiResponse<>(true, motorcycles);
                return ResponseEntity.ok(response);
        }

        @GetMapping("/type/{type}")
        @Operation(summary = "Get motorcycles by type", description = "Retrieve all motorcycles of a specific type", responses = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved motorcycles by type", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.example.sampleapi.dto.MotorcycleListApiResponse.class)))
        })
        public ResponseEntity<ApiResponse<List<Motorcycle>>> getMotorcyclesByType(
                        @Parameter(description = "Type to filter by", required = true) @PathVariable String type) {
                List<Motorcycle> motorcycles = motorcycleService.getMotorcyclesByType(type);
                ApiResponse<List<Motorcycle>> response = new ApiResponse<>(true, motorcycles);
                return ResponseEntity.ok(response);
        }

        @GetMapping("/year/{year}")
        @Operation(summary = "Get motorcycles by year", description = "Retrieve all motorcycles from a specific year", responses = {
                        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved motorcycles by year", content = @Content(mediaType = "application/json", schema = @Schema(implementation = com.example.sampleapi.dto.MotorcycleListApiResponse.class)))
        })
        public ResponseEntity<ApiResponse<List<Motorcycle>>> getMotorcyclesByYear(
                        @Parameter(description = "Year to filter by", required = true) @PathVariable Integer year) {
                List<Motorcycle> motorcycles = motorcycleService.getMotorcyclesByYear(year);
                ApiResponse<List<Motorcycle>> response = new ApiResponse<>(true, motorcycles);
                return ResponseEntity.ok(response);
        }

        @GetMapping("/custom/{id}")
        @Operation(summary = "Get motorcycle with custom response", description = "Retrieve a motorcycle with custom response format")
        public ResponseEntity<CustomResponse<Motorcycle>> getMotorcycleWithCustomResponse(
                        @Parameter(description = "ID of the motorcycle to retrieve", required = true) @PathVariable Long id) {
                return motorcycleService.getMotorcycleById(id)
                                .map(motorcycle -> {
                                        Map<String, Object> headers = new HashMap<>();
                                        headers.put("X-Custom-Header", "Motorcycle-Data");
                                        headers.put("X-Total-Count", motorcycleService.getAllMotorcycles().size());
                                        return ResponseEntity.ok(new CustomResponse<>(200, headers, motorcycle));
                                })
                                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                .body(new CustomResponse<>(404, new HashMap<>(), null)));
        }
}