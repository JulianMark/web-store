package com.webstore.customer.service.impl;

import com.webstore.customer.model.Customer;
import com.webstore.customer.repository.CustomerRepository;
import com.webstore.customer.service.CustomerService;
import com.webstore.customer.util.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, String> implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CrudRepository<Customer, String> getDAO() {
        return repository;
    }
}
