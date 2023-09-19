package com.wferdinando.hexagonal.application.ports.out;

import java.util.Optional;

import com.wferdinando.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {
    
    Optional<Customer> find(String id);
}
