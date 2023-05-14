package ing.transactions.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {

    @Size(min = 26, max = 26)
    @NotNull
    @NotBlank
    @JsonProperty("debitAccount")
    private String debitAccount;

    @Size(min = 26, max = 26)
    @NotNull
    @NotBlank
    @JsonProperty("creditAccount")
    private String creditAccount;

    @NotNull
    @JsonProperty("amount")
    private float amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;

        if (Float.compare(that.amount, amount) != 0) return false;
        if (!debitAccount.equals(that.debitAccount)) return false;
        return creditAccount.equals(that.creditAccount);
    }

    @Override
    public int hashCode() {
        int result = debitAccount.hashCode();
        result = 31 * result + creditAccount.hashCode();
        result = 31 * result + (amount != +0.0f ? Float.floatToIntBits(amount) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "debitAccount='" + debitAccount + '\'' +
                ", creditAccount='" + creditAccount + '\'' +
                ", number=" + amount +
                '}';
    }
}
