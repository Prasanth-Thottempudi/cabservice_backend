package com.nova.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nova.dto.VehicleRequest;
import com.nova.dto.VehicleResponse;
import com.nova.entity.Vehicle;
import com.nova.enums.VehicleCode;
import com.nova.exception.VehicleAlreadyExistsException;
import com.nova.exception.VehicleNotFoundException;
import com.nova.mapper.VehicleMapper;
import com.nova.repository.VehicleRepository;
import com.nova.service.VehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleResponse createVehicle(VehicleRequest request) {

        if (vehicleRepository.existsByVehicleCode(request.getVehicleCode())) {
            throw new VehicleAlreadyExistsException(
                    "Vehicle with code '" + request.getVehicleCode() + "' already exists.");
        }

        Vehicle vehicle = vehicleMapper.toEntity(request);

        Long seq = vehicleRepository.getNextVehicleSequence();

        vehicle.setVehicleSequence(seq);
        vehicle.setVehicleId(String.format("VEH%04d", seq));
        vehicle.setActive(true);

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toResponse(savedVehicle);
    }

    @Override
    public VehicleResponse updateVehicle(String vehicleId, VehicleRequest request) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new VehicleNotFoundException("Vehicle not found with id: " + vehicleId));

        if (!vehicle.getVehicleCode().equals(request.getVehicleCode())
                && vehicleRepository.existsByVehicleCode(request.getVehicleCode())) {

            throw new VehicleAlreadyExistsException(
                    "Vehicle with code '" + request.getVehicleCode() + "' already exists.");
        }

        vehicle.setVehicleCode(request.getVehicleCode());
        vehicle.setVehicleName(request.getVehicleName());
        vehicle.setDescription(request.getDescription());
        vehicle.setBaseFare(request.getBaseFare());
        vehicle.setPricePerKm(request.getPricePerKm());
        vehicle.setDriverAllowance(request.getDriverAllowance());
        vehicle.setMinimumKm(request.getMinimumKm());

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toResponse(updatedVehicle);
    }

  

    @Override
    @Transactional(readOnly = true)
    public List<VehicleResponse> getAllVehicles() {
        return vehicleMapper.toResponseList(vehicleRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleResponse> getActiveVehicles() {
        return vehicleMapper.toResponseList(vehicleRepository.findByActiveTrue());
    }

    @Override
    public void activateVehicle(String vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new VehicleNotFoundException("Vehicle not found with id: " + vehicleId));

        vehicle.setActive(true);

        vehicleRepository.save(vehicle);
    }

    @Override
    public void deactivateVehicle(String vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new VehicleNotFoundException("Vehicle not found with id: " + vehicleId));

        vehicle.setActive(false);

        vehicleRepository.save(vehicle);
    }
    
    @Override
    @Transactional(readOnly = true)
    public VehicleResponse getVehicleByCode(VehicleCode vehicleCode) {

        Vehicle vehicle = vehicleRepository.findByVehicleCode(vehicleCode)
                .orElseThrow(() ->
                        new VehicleNotFoundException(
                                "Vehicle not found with code : " + vehicleCode));

        return vehicleMapper.toResponse(vehicle);
    }
    
    @Override
    @Transactional(readOnly = true)
    public VehicleResponse getVehicle(String vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new VehicleNotFoundException(
                                "Vehicle not found with id: " + vehicleId));

        return vehicleMapper.toResponse(vehicle);
    }
}