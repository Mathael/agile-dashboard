package com.dashboard.api.services;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
public interface DefaultService<T, K> {

    T find(K id);

    List<T> findAll();

    void update(T object);

    void updateAsync(T object);

    void delete(T object);

    void deleteAsync(T object);

    void deleteAsyncById(K id);

    void deleteAll();

    void deleteAllAsync();
}
