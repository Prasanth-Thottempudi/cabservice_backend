package com.nova.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nova.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    /**
     * Find customer by mobile number.
     */
    Optional<Customer> findByMobileNumber(String mobileNumber);

    /**
     * Find customer by email.
     */
    Optional<Customer> findByEmail(String email);

    /**
     * Check mobile number already exists.
     */
    boolean existsByMobileNumber(String mobileNumber);

    /**
     * Check email already exists.
     */
    boolean existsByEmail(String email);

    /**
     * Get all active customers.
     */
    List<Customer> findByActiveTrue();

    /**
     * Get all verified customers.
     */
    List<Customer> findByVerifiedTrue();

    /**
     * Find customer by referral code.
     */
    Optional<Customer> findByReferralCode(String referralCode);

    /**
     * Search customer by first name.
     */
    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);

    /**
     * Search customer by last name.
     */
    List<Customer> findByLastNameContainingIgnoreCase(String lastName);

    /**
     * Search customer by mobile or email.
     */
    @Query("""
            SELECT c
            FROM Customer c
            WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR c.mobileNumber LIKE CONCAT('%', :keyword, '%')
            """)
    List<Customer> searchCustomers(String keyword);

    /**
     * Get active customers with pagination.
     */
    Page<Customer> findByActiveTrue(Pageable pageable);

    /**
     * Get all customers with pagination.
     */
    Page<Customer> findAll(Pageable pageable);

}