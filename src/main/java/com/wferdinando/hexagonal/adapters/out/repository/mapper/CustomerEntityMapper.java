package com.wferdinando.hexagonal.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.wferdinando.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.wferdinando.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.wferdinando.hexagonal.application.core.domain.Address;
import com.wferdinando.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

    Address map(AddressEntity address);
}
