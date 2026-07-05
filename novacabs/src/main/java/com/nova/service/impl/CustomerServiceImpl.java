package com.nova.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nova.dto.CustomerRequest;
import com.nova.dto.CustomerResponse;
import com.nova.entity.Customer;
import com.nova.exception.CustomerAlreadyExistsException;
import com.nova.exception.CustomerNotFoundException;
import com.nova.repository.CustomerRepository;
import com.nova.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {

        Customer customer = new Customer();

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setEmail(request.getEmail());
        customer.setGender(request.getGender());
        customer.setDateOfBirth(request.getDateOfBirth());

        customer.setCustomerNumber(generateCustomerNumber());
        // Default values
        customer.setWalletBalance(0.0);
        customer.setRating(5.0);
        customer.setTotalRides(0);
        customer.setVerified(false);
        customer.setActive(true);

        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new CustomerAlreadyExistsException(
                    request.getEmail() + " already exists.");
        }

        if (customerRepository.existsByMobileNumber(request.getMobileNumber())) {
            throw new CustomerAlreadyExistsException(
                    request.getMobileNumber() + " already exists.");
        }

        Customer savedCustomer = customerRepository.save(customer);

        return convertToResponse(savedCustomer);
    }

    @Override
    public CustomerResponse getCustomerById(UUID customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Customer not found with id: " + customerId));

        return convertToResponse(customer);
    }

    private CustomerResponse convertToResponse(Customer customer) {

        CustomerResponse response = new CustomerResponse();

        response.setCustomerId(customer.getCustomerId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setMobileNumber(customer.getMobileNumber());
        response.setEmail(customer.getEmail());
        response.setGender(customer.getGender());
        response.setDateOfBirth(customer.getDateOfBirth());
        response.setProfilePhotoUrl(customer.getProfilePhotoUrl());
        response.setWalletBalance(customer.getWalletBalance());
        response.setRating(customer.getRating());
        response.setTotalRides(customer.getTotalRides());
        response.setVerified(customer.getVerified());
        response.setActive(customer.getActive());
        response.setReferralCode(customer.getReferralCode());
        response.setReferredBy(customer.getReferredBy());
        response.setCreatedAt(customer.getCreatedAt());
        response.setUpdatedAt(customer.getUpdatedAt());
        response.setCustomerNumber(customer.getCustomerNumber());

        return response;
    }
    
    private String generateCustomerNumber() {

        Optional<Customer> lastCustomer =
                customerRepository.findTopByOrderByCustomerNumberDesc();

        if (lastCustomer.isEmpty()) {
            return "NOVA000001";
        }

        String lastNumber = lastCustomer.get().getCustomerNumber();

        int number = Integer.parseInt(lastNumber.substring(4));

        return String.format("NOVA%06d", number + 1);
    }
}