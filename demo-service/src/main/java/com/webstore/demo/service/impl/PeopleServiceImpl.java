package com.webstore.demo.service.impl;

import com.webstore.demo.entity.Person;
import com.webstore.demo.repository.PeopleRepository;
import com.webstore.demo.service.PeopleService;
import com.webstore.demo.util.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl extends GenericServiceImpl<Person, Long> implements PeopleService {

    private final PeopleRepository repository;

    @Autowired
    public PeopleServiceImpl(PeopleRepository repository) {
        this.repository = repository;
    }

    @Override
    public CrudRepository<Person, Long> getDAO() {
        return repository;
    }
}
