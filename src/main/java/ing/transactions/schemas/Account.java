package ing.transactions.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.io.BigDecimalParser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Account implements Comparable<Account>{

    @Size(min = 26, max = 26)
    @NotNull
    @NotBlank
    @JsonProperty("account")
    private String account;

    @JsonProperty("debitCount")
    private int debitCount;

    @JsonProperty("creditCount")
    private int creditCount;

    @JsonProperty("balance")
    private float balance;

    public Account(String account) {
        this.account = account;
    }

    public void incrementDebitCount() {
        this.debitCount ++;
    }

    public void incrementCreditCount() {
        this.creditCount ++;
    }

    public void addToBalance(float credit) {
        this.balance += credit;
    }

    public void subtractFromBalance(float debit) {
        this.balance -= debit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account1)) return false;

        if (debitCount != account1.debitCount) return false;
        if (creditCount != account1.creditCount) return false;
        return account.equals(account1.account);
    }

    @Override
    public int hashCode() {
        int result = account.hashCode();
        result = 31 * result + debitCount;
        result = 31 * result + creditCount;
        return result;
    }

    @Override
    public int compareTo(Account account) {

        BigDecimal accountNumber = BigDecimalParser.parse(account.getAccount());

        return BigDecimalParser.parse(this.account).compareTo(accountNumber);
    }

    @Override
    public String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", debitCount=" + debitCount +
                ", creditCount=" + creditCount +
                ", balance=" + balance +
                '}';
    }
}
