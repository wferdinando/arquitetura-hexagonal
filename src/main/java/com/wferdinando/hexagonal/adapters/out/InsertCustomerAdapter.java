package com.wferdinando.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wferdinando.hexagonal.adapters.out.repository.CustomerRepository;
import com.wferdinando.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.wferdinando.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.wferdinando.hexagonal.application.core.domain.Customer;
import com.wferdinando.hexagonal.application.ports.out.InsertCustomerOutputPort;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
