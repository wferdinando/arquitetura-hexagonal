package com.wferdinando.hexagonal.application.ports.out;

import com.wferdinando.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
