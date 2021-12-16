package com.webstore.customer.util;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    @Override
    public T save(T entity) {
        return getDAO().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDAO().deleteById(id);
    }

    @Override
    public T get(ID id) {
        return getDAO().findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        getDAO().findAll().forEach(list::add);

        return list;
    }

    public abstract CrudRepository<T, ID> getDAO();
}
