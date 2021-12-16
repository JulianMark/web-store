package com.webstore.shopping.controller;

import com.webstore.shopping.event.impl.GeneratedInvoiceEvent;
import com.webstore.shopping.model.Invoice;
import com.webstore.shopping.model.message.InvoiceMessage;
import com.webstore.shopping.service.InvoiceService;
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

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService service;
    private final GeneratedInvoiceEvent generatedInvoiceEvent;


    @Autowired
    public InvoiceController(InvoiceService service,
                             GeneratedInvoiceEvent generatedInvoiceEvent) {
        this.service = service;
        this.generatedInvoiceEvent = generatedInvoiceEvent;
    }

    @GetMapping("/all")
    List<Invoice> getAll(){
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    Invoice create(@RequestBody Invoice invoice){
        final Invoice obj = service.save(invoice);

        obj.getItems().stream().forEach(
                itemInvoice -> generatedInvoiceEvent.sendMessage(
                        InvoiceMessage.builder().id(invoice.getId())
                                .messageDate(new Date())
                                .productId(itemInvoice.getProductId())
                                .quantity(itemInvoice.getQuantity())
                                .build()
                )
        );

        return obj;
    }

    @PutMapping("{id}")
    Invoice update(@PathVariable String id, @RequestBody Invoice invoice){
        final Invoice invoiceDB = service.get(id);
        return service.save(invoiceDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete (@PathVariable String id){
        service.delete(id);
    }
}
