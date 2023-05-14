package ing.transactions.controllers;

import ing.transactions.schemas.Account;
import ing.transactions.services.AccountService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostConstruct
    public void addAccounts() {

        Account account1 = new Account("66105036543749403346524547");
        Account account2 = new Account("31074318698137062235845814");
        Account account3 = new Account("32309111922661937852684864");
        Account account4 = new Account("06105023389842834748547303");

        accountService.addAccount(account1);
        accountService.addAccount(account2);
        accountService.addAccount(account3);
        accountService.addAccount(account4);
    }

}
