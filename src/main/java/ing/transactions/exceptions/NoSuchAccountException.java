package ing.transactions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchAccountException extends NoSuchElementException {

    public NoSuchAccountException(String s) {
        super(s);
    }

    public NoSuchAccountException() {
        super("No account with specified account number");
    }
}
