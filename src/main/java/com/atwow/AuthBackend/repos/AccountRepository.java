package com.atwow.AuthBackend.repos;

import com.atwow.AuthBackend.units.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByUsername(String username);
}

