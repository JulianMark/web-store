package com.webstore.product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Product {

    @Id
    private String id;

    private String name;
    private Double price;
    private Double stock;
    private String status;
    private Date createAt;
}
