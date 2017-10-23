package com.dashboard.controller;

import com.dashboard.api.services.AccountService;
import com.dashboard.core.model.Account;
import com.dashboard.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dashboard.api.util.PasswordUtil.encode;
import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Leboc Philippe.
 */
@Slf4j
@RestController
@RequestMapping("/account")
@PreAuthorize("hasRole('ROLE_USER')")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = GET)
    public List<AccountDto> retrieveAccounts() {
        return accountService
                .findAll()
                .stream()
                .map(AccountDto::new)
                .sorted(comparingLong(AccountDto::getCreated_time).reversed())
                .collect(toList());
    }

    @RequestMapping(method = POST, consumes = "application/json")
    public boolean create(@RequestBody AccountDto account) {
        final String password = encode(account.getPassword(), "SHA");
        return password != null && accountService.save(new Account(account.getLogin(), password, 0));
    }

    @RequestMapping(value = "/{login}", method = DELETE)
    public boolean remove(@PathVariable("login") String login) {
        return accountService.delete(login);
    }
}
