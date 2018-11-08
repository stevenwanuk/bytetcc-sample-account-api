package com.sven.bytetcc.account.service.tcc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountTccConfirmService")
public class AccountTccConfirmService implements AccountTccService
{
    @Transactional
    @Override
    public void pay(Long accountId, Long orderId)
    {
        // TODO Auto-generated method stub
        
    }


}
