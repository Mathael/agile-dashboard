package com.dashboard.core.repository;

import com.dashboard.core.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leboc Philippe.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
