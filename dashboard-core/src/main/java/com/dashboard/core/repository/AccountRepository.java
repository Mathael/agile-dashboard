package com.dashboard.core.repository;

import com.dashboard.core.model.Account;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
public interface AccountRepository {
    Account findByLogin(String login);
    List<Account> findAll();
    boolean save(final Account account);
    boolean delete(String login);
}
