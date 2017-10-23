package com.dashboard.api.bean.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leboc Philippe.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationRequest {
    private String username;
    private String password;
}