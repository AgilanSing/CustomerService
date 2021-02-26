package com.test.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.customerservice.model.Customer;

/**
 * @author Agilan
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
