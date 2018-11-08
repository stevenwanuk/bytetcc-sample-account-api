package com.sven.bytetcc.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sven.bytetcc.account.exception.AccountApiException;
import com.sven.bytetcc.account.model.Account;
import com.sven.bytetcc.account.model.ProductOrder;
import com.sven.bytetcc.account.repository.AccountRepository;

@Service
public class AccountService
{

    private AccountRepository accountRepository;
    private OrderService orderService;

    public AccountService(AccountRepository accountRepository, OrderService orderService)
    {

        this.accountRepository = accountRepository;
        this.orderService = orderService;
    }

    public List<Account> findAll()
    {

        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long accountId)
    {
        return accountRepository.findById(accountId);
    }

    public void lock(Long accountId, Long orderId)
    {

        Account account = this.getAccountById(accountId)
                        .orElseThrow(() -> new AccountApiException("none of account is found"));

//        ProductOrder order = this.orderService.findOrderById(orderId)
//                        .orElseThrow(() -> new AccountApiException("none of order is found"));
//
//        double amoutNeedToPay = order.getAmount();
        
        double amoutNeedToPay = 100;

        if (account.getAvailableAmount() < amoutNeedToPay)
        {

            throw new AccountApiException("account doesn't have sufficient amount to make a payment");
        }

        account.setAvailableAmount(account.getAvailableAmount() - amoutNeedToPay);
        account.setLockedAmount(account.getLockedAmount() + amoutNeedToPay);

        accountRepository.save(account);
    }
}
