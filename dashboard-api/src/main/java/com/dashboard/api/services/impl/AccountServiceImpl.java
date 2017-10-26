package com.dashboard.api.services.impl;

import com.dashboard.api.services.AccountService;
import com.dashboard.core.model.Account;
import com.dashboard.core.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author Leboc Philippe.
 */
@Slf4j
@Service
@Validated
public class AccountServiceImpl extends DefaultServiceImpl<Account, String, AccountRepository> implements AccountService {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAsyncById(@NotNull String id) {
        super.deleteAsyncById(id);
    }
}
