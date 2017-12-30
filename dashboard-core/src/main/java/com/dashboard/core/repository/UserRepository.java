package com.dashboard.core.repository;

import com.dashboard.core.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leboc Philippe.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
