package com.dashboard.api.services.impl;

import com.dashboard.api.services.AccountService;
import com.dashboard.core.model.Account;
import com.dashboard.core.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
@Slf4j
@Service
@Validated
public class AccountServiceImpl implements AccountService {

    private static final String ACCOUNT_CREATION_SUCCESS = "Account creation [{}] with accessLevel [{}] successful";
    private static final String ACCOUNT_CREATION_FAIL = "Account creation [{}] with accessLevel [{}] has failed";

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public boolean save(@Valid Account account) {
        final boolean result = accountRepository.save(account);

        if(result)
            log.info(ACCOUNT_CREATION_SUCCESS, account.getLogin(), account.getAccessLevel());
        else
            log.warn(ACCOUNT_CREATION_FAIL, account.getLogin(), account.getAccessLevel());

        return result;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public boolean delete(@NotNull @Length(min = 3) String login) {
        return accountRepository.delete(login);
    }
}
