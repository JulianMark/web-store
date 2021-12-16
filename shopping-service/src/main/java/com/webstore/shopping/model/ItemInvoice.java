package com.webstore.shopping.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ItemInvoice {

    @Id
    private String id;

    private String productId;
    private Double price;
    private Double quantity;
}
