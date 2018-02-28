package com.dashboard.api.services.impl;

import com.dashboard.api.services.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;

/**
 * @author LEBOC Philippe
 */
@Validated
public abstract class DefaultServiceImpl<T, K extends Serializable, S extends JpaRepository<T, K>> implements DefaultService<T, K> {

    @Autowired
    protected S repository;

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public T find(K id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(T object) {
        repository.save(object);
    }

    @Async
    @Override
    public void updateAsync(T object) {
        repository.save(object);
    }

    @Async
    @Override
    public void deleteAsync(T object) {
        repository.delete(object);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Async
    @Override
    public void deleteAsyncById(K id) {
        repository.delete(id);
    }

    @Async
    @Override
    public void deleteAllAsync() {
        repository.deleteAll();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
