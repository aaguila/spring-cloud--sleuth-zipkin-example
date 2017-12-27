package com.qajungle.controllers;

import com.qajungle.domain.Account;
import com.qajungle.domain.dto.AccountDto;
import com.qajungle.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountController {

    @Autowired
    private ModelMapper modelMapper;

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    @ResponseBody
    public List<AccountDto> getAccounts() throws Exception {
        List<Account> accounts = accountService.getAccounts();
        return accounts.stream().map(account -> convertToDto(account)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/account/{id}")
    @ResponseBody
    public AccountDto getAccount(@PathVariable("id") Long id) throws Exception {
        return convertToDto(accountService.getAccountById(id));
    }

    private AccountDto convertToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }

}
