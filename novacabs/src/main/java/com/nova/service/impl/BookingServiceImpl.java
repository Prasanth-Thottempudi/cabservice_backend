package com.nova.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nova.dto.BookingRequest;
import com.nova.dto.BookingResponse;
import com.nova.entity.Booking;
import com.nova.mapper.BookingMapper;
import com.nova.repository.BookingRepository;
import com.nova.service.BookingService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private  BookingRepository bookingRepository;
    private  BookingMapper bookingMapper;
    
    

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
		super();
		this.bookingRepository = bookingRepository;
		this.bookingMapper = bookingMapper;
	}

    @Override
    public BookingResponse createBooking(BookingRequest request) {

        Booking booking = bookingMapper.toEntity(request);

        generateBookingDetails(booking);

        Booking savedBooking = bookingRepository.save(booking);

        BookingResponse response = bookingMapper.toResponse(savedBooking);
        response.setMessage("Booking created successfully.");

        return response;
    }


    @Override
    public BookingResponse getBookingById(String bookingId) {

        Booking booking = bookingRepository.findById(UUID.fromString(bookingId))
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        return bookingMapper.toResponse(booking);
    }

    @Override
    public BookingResponse getBookingByNumber(String bookingNumber) {

        Booking booking = bookingRepository.findByBookingNumber(bookingNumber)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        return bookingMapper.toResponse(booking);
    }

    
	private void generateBookingDetails(Booking booking) {

	    Long sequence = bookingRepository.getNextBookingSequence();

	    booking.setBookingSequence(sequence);
	    booking.setBookingNumber(String.format("NC%06d", sequence));
	}
}