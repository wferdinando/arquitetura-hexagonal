package com.wferdinando.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wferdinando.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.wferdinando.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByidAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByidAdapter);
    }
}
