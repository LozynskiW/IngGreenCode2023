package ing.transactions.schemas;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Transactions {

    private final List<Transaction> transactionsList = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactionsList.add(transaction);

    }

    public List<Transaction> getTransactionsList() {
        return this.transactionsList;
    }
}
