package com.webstore.shopping.service.impl;

import com.webstore.shopping.model.Invoice;
import com.webstore.shopping.repository.InvoiceRepository;
import com.webstore.shopping.service.InvoiceService;
import com.webstore.shopping.util.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl extends GenericServiceImpl<Invoice, String> implements InvoiceService {

    private final InvoiceRepository repository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public CrudRepository<Invoice, String> getDAO() {
        return repository;
    }
}
