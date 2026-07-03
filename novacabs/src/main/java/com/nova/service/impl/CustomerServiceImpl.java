package com.nova.service.impl;


import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nova.dto.CustomerRequest;
import com.nova.dto.CustomerResponse;
import com.nova.entity.Customer;
import com.nova.exception.CustomerAlreadyExistsException;
import com.nova.exception.CustomerNotFoundException;
import com.nova.repository.CustomerRepository;
import com.nova.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    
}