package com.wferdinando.hexagonal.application.ports.out;

import com.wferdinando.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    
    Address find(String zipCode);

}
