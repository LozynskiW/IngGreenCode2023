package ing.transactions.schemas;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Component
public class Accounts {

    private final List<Account> accountList = new LinkedList<>();

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void sortAccounts() {
        accountList.sort(Account::compareTo);
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();

        for (Account a : this.accountList) {
            output.append(a.toString());
            output.append(" ");
        }
        return output.toString();
    }
}
