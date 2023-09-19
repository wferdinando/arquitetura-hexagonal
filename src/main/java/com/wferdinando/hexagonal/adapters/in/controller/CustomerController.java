package com.wferdinando.hexagonal.adapters.in.controller;

import javax.validation.Valid;

import com.wferdinando.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.wferdinando.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wferdinando.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.wferdinando.hexagonal.adapters.in.controller.request.CustomerResquest;
import com.wferdinando.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.wferdinando.hexagonal.application.core.domain.Customer;
import com.wferdinando.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.wferdinando.hexagonal.application.ports.in.InsertCustomerInputPort;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerResquest customerResquest) {
        Customer customer = customerMapper.toCustomer(customerResquest);
        insertCustomerInputPort.insert(customer, customerResquest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final String id, @Valid @RequestBody CustomerResquest customerResquest) {
        Customer customer = customerMapper.toCustomer(customerResquest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerResquest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
