package com.dashboard.api.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
public interface DefaultService<T, K> {
    T save(@NotNull @Valid T object);
    T find(K id);
    List<T> findAll();
    void update(@NotNull @Valid T object);
    void updateAsync(@NotNull @Valid T object);
    void delete(@NotNull @Valid T object);
    void deleteAsync(@NotNull @Valid T object);
    void deleteAsyncById(K id);
    void deleteAll();
    void deleteAllAsync();
}
