package com.dashboard.core.repository;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
public interface CrudRepository<K, T> {

    T find(K id);

    List<T> findAll();

    boolean update(T object);

    boolean delete(T object);

    boolean deleteById(K id);

    boolean create(T object);
}
