package com.dashboard.api.services.impl;

import com.dashboard.api.services.DefaultService;
import com.dashboard.core.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LEBOC Philippe
 */
@Service
public abstract class DefaultServiceImpl<T, K, S extends CrudRepository<K, T>> implements DefaultService<T, K> {

    @Autowired
    protected S repository;

    @Override
    public T find(K id) {
        return repository.find(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(T object) {
        repository.update(object);
    }

    @Async
    @Override
    public void updateAsync(T object) {
        repository.update(object);
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
        repository.deleteById(id);
    }

    @Async
    @Override
    public void deleteAllAsync() {
        // TODO: implement me
    }

    @Override
    public void deleteAll() {
        // TODO: implement me
    }
}
