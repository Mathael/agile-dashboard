package com.dashboard.api.services;

import com.dashboard.core.model.Account;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
public interface AccountService {
    List<Account> findAll();
    boolean save(@Valid Account account);
    boolean delete(@NotNull @Length(min = 3) String login);
}
