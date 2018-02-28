package com.dashboard.boot.config;

import com.dashboard.api.annotation.profiles.Dev;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author LEBOC Philippe
 */
@Slf4j
@Configuration
@EnableWebSecurity
@SuppressWarnings("SpringJavaAutowiringInspection")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .exceptionHandling().authenticationEntryPoint(null)
            .and()

            // don't create session
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

            // allow anonymous resource requests
            .antMatchers(HttpMethod.GET, "/favicon.ico").permitAll()
            .antMatchers("/h2/**").permitAll()
            .antMatchers("/resources/**", "/register").permitAll()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/api/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated();

        // Custom JWT based security filter
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().disable();
        http.httpBasic();
    }

    @Dev
    @Bean
    public UserDetailsService userDetailsService() {
        final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());
        manager.createUser(User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build());
        return manager;
    }
}
