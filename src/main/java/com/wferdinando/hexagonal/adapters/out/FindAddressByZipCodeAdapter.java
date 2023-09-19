package com.wferdinando.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wferdinando.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.wferdinando.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.wferdinando.hexagonal.adapters.out.client.response.AddressResponse;
import com.wferdinando.hexagonal.application.core.domain.Address;
import com.wferdinando.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
