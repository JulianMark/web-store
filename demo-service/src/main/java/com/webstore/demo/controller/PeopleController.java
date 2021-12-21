package com.webstore.demo.controller;

import com.webstore.demo.entity.Person;
import com.webstore.demo.service.PeopleService;
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
@RequestMapping("/api")
public class PeopleController {

    final PeopleService service;

    @Autowired
    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @GetMapping("/")
    List<Person> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    Person getById(@PathVariable Long id){
        return service.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    Person create(@RequestBody Person person){
        return service.save(person);
    }

    @PutMapping("{id}")
    Person update(@PathVariable Long id, @RequestBody Person person){
        final Person personDB = service.get(id);
        personDB.setName(person.getName());
        personDB.setSurname(personDB.getSurname());
        return service.save(personDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete (@PathVariable Long id){
        service.delete(id);
    }
}
