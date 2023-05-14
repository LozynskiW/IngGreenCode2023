package ing.transactions.services;

import ing.transactions.schemas.Account;
import ing.transactions.schemas.Accounts;
import ing.transactions.schemas.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Objects;

@Service
public class AccountService {

    @Autowired
    private Accounts accountList;

    public void addAccount(Account account) {

        accountList.addAccount(account);
    }

    private int getAccountIndexByAccountNumber(Account account) {

        return accountList.getAccountList().indexOf(account);
    }

    public List<Account> getAllAccounts() {

        this.accountList.sortAccounts();

        return this.accountList.getAccountList();
    }

    public Account getAccountByAccountNumber(String accountNumber) {

        return accountList.getAccountList().stream()
                .filter(a -> Objects.equals(a.getAccount(), accountNumber))
                .findFirst().orElseThrow();

    }

    public void updateAccount(Account accountToUpdate) {

        Account accountBeforeUpdate = this.getAccountByAccountNumber(accountToUpdate.getAccount());

        int accountIndex = this.getAccountIndexByAccountNumber(accountBeforeUpdate);

        accountList.getAccountList().remove(accountIndex);
        accountList.getAccountList().add(accountIndex, accountToUpdate);

    }

    @Transactional
    public void executeTransaction(Transaction transaction) {

        Account creditAccount = this.getAccountByAccountNumber(transaction.getCreditAccount());
        Account debitAccount = this.getAccountByAccountNumber(transaction.getDebitAccount());

        creditAccount.addToBalance(transaction.getAmount());
        creditAccount.incrementCreditCount();
        debitAccount.subtractFromBalance(transaction.getAmount());
        debitAccount.incrementDebitCount();

        this.updateAccount(creditAccount);
        this.updateAccount(debitAccount);

    }
}
