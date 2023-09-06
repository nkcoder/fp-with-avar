package my.playground.value.validation;

public class AgeIsLessThan18 implements ValidationError {
    @Override
    public String errorMessage() {
        return "age must be over 18";
    }
}
