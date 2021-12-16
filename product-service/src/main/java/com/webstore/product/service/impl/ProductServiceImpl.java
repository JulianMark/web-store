package com.webstore.product.service.impl;

import com.webstore.product.model.Product;
import com.webstore.product.repository.ProductRepository;
import com.webstore.product.service.ProductService;
import com.webstore.product.util.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, String> implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public CrudRepository<Product, String> getDAO() {
        return repository;
    }
}
