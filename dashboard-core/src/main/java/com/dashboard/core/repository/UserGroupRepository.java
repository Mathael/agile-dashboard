package com.dashboard.core.repository;

import com.dashboard.core.model.user.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leboc Philippe.
 */
@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
}
