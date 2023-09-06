package my.playground.value.validation;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;

public class AccountValidation {
    public static Validation<Seq<ValidationError>, Account> validateAccount(String name, Integer age, Double amount) {
        return Validation.combine(validateName(name), validateAge(age), validateAmount(amount)).ap(Account::new);
    }

    private static Validation<ValidationError, String> validateName(String name) {
        if (name == null || name.isEmpty()) {
            return Validation.invalid(new NameIsEmpty());
        }
        return Validation.valid(name);
    }

    private static Validation<ValidationError, Integer> validateAge(Integer age) {
        if (age == null || age < 18) {
            return Validation.invalid(new AgeIsLessThan18());
        }
        return Validation.valid(age);
    }

    private static Validation<ValidationError, Double> validateAmount(Double amount) {
        if (amount == null || amount <= 0) {
            return Validation.invalid(new AmountIsNegative());
        }
        return Validation.valid(amount);
    }
}
