package com.nova.service;

import java.util.List;

import com.nova.dto.VehicleRequest;
import com.nova.dto.VehicleResponse;
import com.nova.enums.VehicleCode;

public interface VehicleService {

    VehicleResponse createVehicle(VehicleRequest request);

    VehicleResponse updateVehicle(String vehicleId, VehicleRequest request);

    VehicleResponse getVehicleByCode(VehicleCode vehicleCode);
    List<VehicleResponse> getAllVehicles();

    List<VehicleResponse> getActiveVehicles();

    void activateVehicle(String vehicleId);

    void deactivateVehicle(String vehicleId);
    VehicleResponse getVehicle(String vehicleId);

}