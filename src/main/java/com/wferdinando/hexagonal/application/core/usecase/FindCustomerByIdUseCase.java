package com.wferdinando.hexagonal.application.core.usecase;

import com.wferdinando.hexagonal.application.core.domain.Customer;
import com.wferdinando.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.wferdinando.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found."));
    }
}
