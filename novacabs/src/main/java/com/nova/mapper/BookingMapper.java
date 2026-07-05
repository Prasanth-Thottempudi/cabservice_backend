package com.nova.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nova.dto.BookingRequest;
import com.nova.dto.BookingResponse;
import com.nova.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking toEntity(BookingRequest request);

    @Mapping(source = "id", target = "bookingId")
    BookingResponse toResponse(Booking booking);

}