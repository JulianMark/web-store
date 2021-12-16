package com.webstore.product.controller;

import com.webstore.product.model.Product;
import com.webstore.product.service.ProductService;
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
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    List<Product> getAll(){
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    Product create(@RequestBody Product product){
        return service.save(product);
    }

    @PutMapping("{id}")
    Product update(@PathVariable String id, @RequestBody Product product){
        final Product productDB = service.get(id);
        productDB.setName(product.getName());
        productDB.setPrice(product.getPrice());
        return service.save(productDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete (@PathVariable String id){
        service.delete(id);
    }
}
