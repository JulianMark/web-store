package com.webstore.shopping.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Invoice {

    @Id
    private String id;

    private String number;
    private String customerId;
    private Date createAt;

    private List<ItemInvoice> items;
}
