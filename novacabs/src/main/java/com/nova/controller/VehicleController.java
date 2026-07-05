package com.nova.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dto.VehicleRequest;
import com.nova.dto.VehicleResponse;
import com.nova.enums.VehicleCode;
import com.nova.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicles")
@Validated
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> createVehicle(
            @Valid @RequestBody VehicleRequest request) {

        return new ResponseEntity<>(
                vehicleService.createVehicle(request),
                HttpStatus.CREATED);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponse> updateVehicle(
            @PathVariable String vehicleId,
            @Valid @RequestBody VehicleRequest request) {

        return ResponseEntity.ok(
                vehicleService.updateVehicle(vehicleId, request));
    }

    @GetMapping("/code/{vehicleCode}")
    public ResponseEntity<VehicleResponse> getVehicleByCode(
            @PathVariable VehicleCode vehicleCode) {

        return ResponseEntity.ok(
                vehicleService.getVehicleByCode(vehicleCode));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getAllVehicles() {

        return ResponseEntity.ok(
                vehicleService.getAllVehicles());
    }

    @GetMapping("/active")
    public ResponseEntity<List<VehicleResponse>> getActiveVehicles() {

        return ResponseEntity.ok(
                vehicleService.getActiveVehicles());
    }

    @PutMapping("/{vehicleId}/activate")
    public ResponseEntity<Void> activateVehicle(
            @PathVariable String vehicleId) {

        vehicleService.activateVehicle(vehicleId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{vehicleId}/deactivate")
    public ResponseEntity<Void> deactivateVehicle(
            @PathVariable String vehicleId) {

        vehicleService.deactivateVehicle(vehicleId);

        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponse> getVehicle(
            @PathVariable String vehicleId) {

        return ResponseEntity.ok(
                vehicleService.getVehicle(vehicleId));
    }
}