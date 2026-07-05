package com.nova.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.nova.dto.VehicleRequest;
import com.nova.dto.VehicleResponse;
import com.nova.entity.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    Vehicle toEntity(VehicleRequest request);

    VehicleResponse toResponse(Vehicle vehicle);

    List<VehicleResponse> toResponseList(List<Vehicle> vehicles);

}