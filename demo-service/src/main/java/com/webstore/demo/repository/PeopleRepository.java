package com.webstore.demo.repository;

import com.webstore.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Long> {
}
