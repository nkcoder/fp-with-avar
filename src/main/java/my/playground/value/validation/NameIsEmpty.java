package my.playground.value.validation;

public class NameIsEmpty implements ValidationError {
    @Override
    public String errorMessage() {
        return "name must not be empty.";
    }


}
