package ing.transactions.controllers;

import ing.transactions.exceptions.NoSuchAccountException;
import ing.transactions.schemas.Account;
import ing.transactions.schemas.Transaction;
import ing.transactions.services.AccountService;
import ing.transactions.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    private final AccountService accountService;

    @Autowired
    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @PostMapping(path = "/report")
    public List<Account> registerTransactions(@RequestBody Transaction... transactions) {

        for (Transaction transaction : transactions) {

            try {
                transactionService.registerTransaction(transaction);

            } catch (NoSuchElementException e) {

                e.printStackTrace();
                throw new NoSuchAccountException();
            }

        }

        return accountService.getAllAccounts();

    }
}
