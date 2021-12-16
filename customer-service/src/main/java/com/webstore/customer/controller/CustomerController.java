package com.webstore.customer.controller;

import com.webstore.customer.model.Customer;
import com.webstore.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    List<Customer> getAll(){
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    Customer create(@RequestBody Customer customer){
        return service.save(customer);
    }

    @PutMapping("{id}")
    Customer update(@PathVariable String id, @RequestBody Customer customer){
        final Customer customerDB = service.get(id);
        customerDB.setName(customer.getName());
        customerDB.setSurname(customer.getSurname());
        return service.save(customerDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete (@PathVariable String id){
        service.delete(id);
    }
}
