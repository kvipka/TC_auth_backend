package com.atwow.AuthBackend.repos;

import com.atwow.AuthBackend.units.AccountAccess;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAccessRepository extends CrudRepository<AccountAccess, Long> {
    @Cacheable("cache_account_access")
    AccountAccess findByAccountID(Long accID);
}
