package com.wferdinando.hexagonal.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import com.wferdinando.hexagonal.adapters.out.client.response.AddressResponse;
import com.wferdinando.hexagonal.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
