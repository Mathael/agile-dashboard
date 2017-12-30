package com.dashboard.api.services.impl;

import com.dashboard.api.services.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author LEBOC Philippe
 */
@Validated
public abstract class DefaultServiceImpl<T, ID extends Serializable, S extends JpaRepository<T, ID>> implements DefaultService<T, ID> {

    @Autowired
    protected S repository;

    @Override
    public T save(@Valid T object) {
        return repository.save(object);
    }

    @Override
    public T find(@NotNull ID id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(@Valid T object) {
        repository.save(object);
    }

    @Async
    @Override
    public void updateAsync(@Valid T object) {
        repository.save(object);
    }

    @Async
    @Override
    public void deleteAsync(@NotNull T object) {
        repository.delete(object);
    }

    @Override
    public void delete(@NotNull T object) {
        repository.delete(object);
    }

    @Async
    @Override
    public void deleteAsyncById(@NotNull ID id) {
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
