package org.learn.axonframework.axonlt.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, String> {
}
