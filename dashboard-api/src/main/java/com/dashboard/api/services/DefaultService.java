package com.dashboard.api.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
public interface DefaultService<T, ID> {

    /**
     *
     * @param object
     * @return
     */
    T save(@Valid T object);

    /**
     *
     * @param id
     * @return
     */
    T find(@NotNull ID id);

    /**
     *
     * @return
     */
    List<T> findAll();

    /**
     *
     * @param object
     */
    void update(@Valid T object);

    /**
     *
     * @param object
     */
    void updateAsync(@Valid T object);

    /**
     *
     * @param object
     */
    void delete(@NotNull T object);

    /**
     *
     * @param object
     */
    void deleteAsync(@NotNull T object);

    /**
     *
     * @param id
     */
    void deleteAsyncById(@NotNull ID id);

    /**
     *
     */
    void deleteAll();

    /**
     *
     */
    void deleteAllAsync();
}
