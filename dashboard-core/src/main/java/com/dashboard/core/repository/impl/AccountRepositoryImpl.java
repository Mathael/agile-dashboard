package com.dashboard.core.repository.impl;

import com.dashboard.core.model.Account;
import com.dashboard.core.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Leboc Philippe.
 */
@Slf4j
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    // System Message
    private static final String LOG_ACCOUNT_REGISTERED = "New account login [{}] with accessLevel [{}] has been created. Database return {}";
    private static final String LOG_ACCOUNT_DELETED = "Account login [{}] has been deleted. Database return {}";
    private static final String WARN_CANNOT_CREATE_ACCOUNT = "Account login [{}] cannot be created.";

    // Sql
    private static final String SELECT_ALL = "SELECT * FROM accounts";
    private static final String FIND_BY_LOGIN = "SELECT * FROM accounts WHERE login = ?";
    private static final String INSERT = "INSERT INTO accounts(login, password, accessLevel) VALUES(?,?,?)";
    private static final String DELETE = "DELETE FROM accounts WHERE login = ?";

    @Autowired
    @Qualifier("jdbcLineage")
    private JdbcTemplate database;

    @Override
    public Account findByLogin(String login) {
        List<Account> data = database.query(FIND_BY_LOGIN, (rs, rowNum) ->
                new Account(rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getTimestamp("created_time").getTime(),
                        rs.getLong("lastActive"),
                        rs.getInt("accessLevel")), login);
        return data.stream().findFirst().orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return database.query(SELECT_ALL, (rs, rowNum) ->
            new Account(rs.getString("login"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getTimestamp("created_time").getTime(),
                rs.getLong("lastActive"),
                rs.getInt("accessLevel")));
    }

    @Override
    public boolean save(final Account account) {
        boolean result = false;
        try {
            final int res = database.update(INSERT, account.getLogin(), account.getPassword(), account.getAccessLevel());
            log.info(LOG_ACCOUNT_REGISTERED, account.getLogin(), account.getAccessLevel(), res);
            result = true;
        } catch (DataAccessException e) {
            log.warn(WARN_CANNOT_CREATE_ACCOUNT, account.getLogin());
        } catch (Exception e) {
            log.warn(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String login) {
        boolean result = false;
        try {
            final int res = database.update(DELETE, login);
            log.info(LOG_ACCOUNT_DELETED, login, res);
            result = true;
        } catch (DataAccessException e) {
            log.warn(e.getMessage());
        } catch (Exception e) {
            log.warn(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
