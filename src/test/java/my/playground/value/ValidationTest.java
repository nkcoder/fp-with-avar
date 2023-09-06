package my.playground.value;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import my.playground.value.validation.Account;
import my.playground.value.validation.AccountValidation;
import my.playground.value.validation.ValidationError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationTest {

    @Test
    public void shouldReturnValidAccount() {
        Validation<Seq<ValidationError>, Account> validationResult = AccountValidation.validateAccount("Jack", 20, 100.5);
        assertTrue(validationResult.isValid());

        Account account = validationResult.get();
        assertEquals("Jack", account.name());
        assertEquals(20, account.age());
        assertEquals(100.5, account.amount());
    }

    @Test
    public void shouldReturnAllErrors() {
        Validation<Seq<ValidationError>, Account> validationResult = AccountValidation.validateAccount("", 5, -30.6);
        assertTrue(validationResult.isInvalid());

        Seq<ValidationError> errors = validationResult.getError();
        assertEquals(3, errors.size());
    }
}

