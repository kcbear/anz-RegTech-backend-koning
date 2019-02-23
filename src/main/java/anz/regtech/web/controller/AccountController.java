package anz.regtech.web.controller;

import anz.regtech.model.Account;
import anz.regtech.model.Transaction;
import anz.regtech.service.AccountService;
import anz.regtech.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService;

    private TransactionService transactionService;

    protected AccountController() {
    }

    @Autowired
    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Account> listAccounts() {
        logger.info("Received listing accounts request");

        return accountService.listAccounts();
    }


    @RequestMapping(path = "/transactions/{accountNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Transaction> listTransactions(@PathVariable("accountNumber") String accountNumber) {
        logger.info("Received listing transactions request with accountNumber [{}]", accountNumber);

        return transactionService.listTransactionsByAccountNumber(accountNumber);
    }


}
