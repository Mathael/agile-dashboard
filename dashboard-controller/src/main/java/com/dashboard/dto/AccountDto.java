package com.dashboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.dashboard.core.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Leboc Philippe.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public final class AccountDto {
    private String login;
    private String password;
    private long created_time;
    private long lastActive;
    private int accessLevel;

    public AccountDto(Account account){
        this(account.getLogin(), null, account.getCreated_time(), account.getLastActive(), account.getAccessLevel());
    }
}
