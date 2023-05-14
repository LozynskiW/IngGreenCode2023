package ing.transactions.services;

import ing.transactions.exceptions.NoSuchAccountException;
import ing.transactions.schemas.Account;
import ing.transactions.schemas.Transaction;
import ing.transactions.schemas.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransactionService {

    @Autowired
    private Transactions transactionsList;
    @Autowired
    private AccountService accountService;

    @Transactional
    public void registerTransaction(Transaction transaction) {

        accountService.executeTransaction(transaction);

        transactionsList.addTransaction(transaction);

    }

    public List<Transaction> getAllTransactions() {

        return this.transactionsList.getTransactionsList();
    }
}
