package com.sven.bytetcc.account.service.tcc;

import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.CompensableContext;
import org.springframework.stereotype.Service;

import com.sven.bytetcc.account.service.AccountService;

@Service("accountTccTryService")
public class AccountTccTryService implements AccountTccService, CompensableContextAware
{

    private CompensableContext compensableContext;

    private AccountService accountService;

    public AccountTccTryService(AccountService accountService)
    {
        this.accountService = accountService;
    }

    // @Transactional
    @Override
    public void pay(Long accountId, Long orderId)
    {
        accountService.lock(accountId, orderId);

    }

    @Override
    public void setCompensableContext(CompensableContext compensableContext)
    {
        this.compensableContext = compensableContext;

    }

}
