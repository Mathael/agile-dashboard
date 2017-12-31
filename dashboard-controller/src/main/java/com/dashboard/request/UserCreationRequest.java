package com.dashboard.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Leboc Philippe.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequest {

    private String username;
    private String password;
    private String email;

}
