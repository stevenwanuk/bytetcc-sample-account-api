package com.sven.bytetcc.account.controller;

import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sven.bytetcc.account.service.tcc.AccountTccService;

import io.swagger.annotations.Api;

@Compensable(interfaceClass = AccountTccService.class, confirmableKey = "accountTccConfirmService",
                cancellableKey = "accountTccCancelService")
@Api
@RestController
@RequestMapping("/tcc/accounts")
public class AccountTccController
{
    
    private AccountTccService accountTccTryService;
    
    public AccountTccController(@Qualifier("accountTccTryService") AccountTccService accountTccTryService) {
        this.accountTccTryService = accountTccTryService;
    }

    @Transactional(transactionManager="transactionManager")
    @PostMapping("/{accountId}/pay")
    public void pay(@PathVariable("accountId") Long accountId, @RequestParam("orderId") Long orderId)
    {

        accountTccTryService.pay(accountId, orderId);
    }
}
