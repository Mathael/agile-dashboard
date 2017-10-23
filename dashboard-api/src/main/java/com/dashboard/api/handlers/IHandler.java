package com.dashboard.api.handlers;

/**
 * @author Leboc Philippe.
 * @param <K> The Handler
 * @param <V> The Handler's key
 */
public interface IHandler<K, V>
{
    /**
     * @param handler The handlers to be registered
     */
    void registerHandler(K handler);

    /**
     * @param handler The handlers to be removed
     */
    void removeHandler(K handler);

    /**
     * @param val The given command
     * @return The handlers corresponding to the command key
     */
    K getHandler(V val);

    /**
     * @return The registered handlers count
     */
    int size();
}