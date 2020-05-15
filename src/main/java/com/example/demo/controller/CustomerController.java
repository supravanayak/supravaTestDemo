package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRespository;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {


    @Autowired
    private CustomerRespository CustomerRepository;

    @GetMapping("/Customers")
    public List<Customer> getAllCustomers() {
        return CustomerRepository.findAll();
    }

    @GetMapping("/Customers/{id}")
    public ResponseEntity < Customer > getCustomerById(@PathVariable(value = "id") Long CustomerId)
    throws ResourceNotFoundException {
        Customer Customer = CustomerRepository.findById(CustomerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));
        return ResponseEntity.ok().body(Customer);
    }

    @PostMapping("/Customers")
    public Customer createCustomer(@Valid @RequestBody Customer Customer) {
        return CustomerRepository.save(Customer);
    }

    @PutMapping("/Customers/{id}")
    public ResponseEntity < Customer > updateCustomer(@PathVariable(value = "id") Long CustomerId,
        @Valid @RequestBody Customer CustomerDetails) throws ResourceNotFoundException {
        Customer Customer = CustomerRepository.findById(CustomerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));

        Customer.setEmail(CustomerDetails.getEmail());
        Customer.setLastName(CustomerDetails.getLastName());
        Customer.setFirstName(CustomerDetails.getFirstName());
        final Customer updatedCustomer = CustomerRepository.save(Customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/Customers/{id}")
    public Map < String, Boolean > deleteCustomer(@PathVariable(value = "id") Long CustomerId)
    throws ResourceNotFoundException {
        Customer Customer = CustomerRepository.findById(CustomerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));

        CustomerRepository.delete(Customer);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    
}
}
