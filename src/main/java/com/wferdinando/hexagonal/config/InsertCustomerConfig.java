package com.wferdinando.hexagonal.config;

import com.wferdinando.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.wferdinando.hexagonal.adapters.out.InsertCustomerAdapter;
import com.wferdinando.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.wferdinando.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter) {

        return new InsertCustomerUseCase(findAddressByZipCodeAdapter,
                insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
