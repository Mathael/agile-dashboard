package com.dashboard.core.repository;

import com.dashboard.core.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Leboc Philippe.
 */
@Validated
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Find an User by his username
     * @param username The given username
     * @return The corresponding User, otherwise null
     */
    User findByUsername(@NotBlank @Size(min = 8, max = 30) String username);
}
