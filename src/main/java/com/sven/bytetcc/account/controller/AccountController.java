package com.sven.bytetcc.account.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sven.bytetcc.account.model.Account;
import com.sven.bytetcc.account.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/accounts")
public class AccountController
{

    private AccountService accountService;

    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;

    }

    @ApiOperation("find all")
    @GetMapping(produces = "application/json")
    public List<Account> findAll()
    {
        return accountService.findAll();
    }
}
