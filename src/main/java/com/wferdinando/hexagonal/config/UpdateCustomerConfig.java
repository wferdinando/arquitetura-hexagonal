package com.wferdinando.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wferdinando.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.wferdinando.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.wferdinando.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.wferdinando.hexagonal.application.core.usecase.UpdateCustomerUseCase;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, UpdateCustomerAdapter updateCustomerAdapter){
        return new UpdateCustomerUseCase(findAddressByZipCodeAdapter, findCustomerByIdUseCase, updateCustomerAdapter);
    }
}
