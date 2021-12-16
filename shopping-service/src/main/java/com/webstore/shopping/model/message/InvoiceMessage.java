package com.webstore.shopping.model.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InvoiceMessage {

    private String id;
    private String productId;
    private Double quantity;
    private Date messageDate;
}
