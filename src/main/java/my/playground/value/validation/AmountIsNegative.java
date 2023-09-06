package my.playground.value.validation;

public class AmountIsNegative implements ValidationError {
    @Override
    public String errorMessage() {
        return "amount must be positive";
    }
}
