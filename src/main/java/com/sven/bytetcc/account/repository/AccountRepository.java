package com.sven.bytetcc.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sven.bytetcc.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{

}
