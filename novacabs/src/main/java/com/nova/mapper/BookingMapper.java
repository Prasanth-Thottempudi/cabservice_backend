package com.nova.mapper;

import org.mapstruct.Mapper;

import com.nova.dto.BookingRequest;
import com.nova.dto.BookingResponse;
import com.nova.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking toEntity(BookingRequest request);

    BookingResponse toResponse(Booking booking);

}