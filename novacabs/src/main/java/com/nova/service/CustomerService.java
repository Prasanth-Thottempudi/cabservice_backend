package com.nova.service;

import java.util.UUID;

import com.nova.dto.CustomerRequest;
import com.nova.dto.CustomerResponse;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest request);

    CustomerResponse getCustomerById(UUID customerId);

}