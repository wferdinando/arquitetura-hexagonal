package com.wferdinando.hexagonal.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.wferdinando.hexagonal.adapters.in.controller.request.CustomerResquest;
import com.wferdinando.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.wferdinando.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerResquest customerResquest);

    CustomerResponse toCustomerResponse(Customer customer);
    
}
