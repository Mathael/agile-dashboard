package com.dashboard.core.repository.impl;

import com.dashboard.core.model.DatabaseProperties;
import com.dashboard.core.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
public class CrudRepositoryImpl<K, T extends DatabaseProperties> implements CrudRepository<K, T> {

    @Autowired
    protected JdbcTemplate database;


    @Override
    public T find(K id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public boolean update(T object) {
        return false;
    }

    @Override
    public boolean delete(T object) {
        return false;
    }

    @Override
    public boolean deleteById(K id) {
        return false;
    }

    @Override
    public boolean create(T object) {
        return false;
    }
}
