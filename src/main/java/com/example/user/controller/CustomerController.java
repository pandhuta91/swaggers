package com.example.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.example.user.exception.ResourceNotFoundException;
import com.example.user.model.Customers;
import com.example.user.repository.CustomersRepository;
import io.swagger.annotations.Api;
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


@RestController
@RequestMapping("/api/v2")
@Api(description = "Customer CRUD", produces = "application/json")
public class CustomerController {

    @Autowired
    private CustomersRepository customersRepository;


    @GetMapping("/customers")
    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }


    @GetMapping("/customers/{id}")
    public ResponseEntity<Customers> getCustomersById(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        Customers customers = customersRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Costumers not found for this id", " :: "));
        ;
        return ResponseEntity.ok().body(customers);
    }


    @PostMapping("/customers")
    public Customers createCustomers(@Valid @RequestBody Customers customers) {
        return customersRepository.save(customers);
    }


    @PutMapping("/customers/{id}")
    public ResponseEntity<Customers> updateCustomers(@PathVariable(value = "id") Long customersId,
                                                     @Valid @RequestBody Customers customersDetails) throws ResourceNotFoundException {
        Customers customers = customersRepository.findById(customersId)
                .orElseThrow(() -> new ResourceNotFoundException("Customers not found for this id", " :: " + customersId));
        customers.setCust_id(customersDetails.getCust_id());
        customers.setCust_name(customersDetails.getCust_name());
        customers.setCust_address(customersDetails.getCust_address());
        final Customers updatedCustomers = customersRepository.save(customers);
        return ResponseEntity.ok(updatedCustomers);
    }


    @DeleteMapping("/customersdelete/{id}")
    public Map<String, Boolean> deleteCostumers(@PathVariable(value = "id") Long costumersId)
            throws ResourceNotFoundException {
        Customers customers = customersRepository.findById(costumersId)
                .orElseThrow(() -> new ResourceNotFoundException("Customers not found for this id", ":: " + costumersId));

        customersRepository.delete(customers);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}