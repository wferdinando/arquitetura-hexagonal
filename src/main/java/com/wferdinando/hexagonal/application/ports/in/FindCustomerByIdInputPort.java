package com.wferdinando.hexagonal.application.ports.in;

import com.wferdinando.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    
    Customer find(String id);
}
