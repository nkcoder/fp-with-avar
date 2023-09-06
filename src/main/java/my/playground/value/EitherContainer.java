package my.playground.value;

import io.vavr.control.Either;

public interface EitherContainer {
    static Either<String, Integer> divide(Integer x, Integer y) {
        if (y == 0) {
            return Either.left("Error: divide by zero");
        } else {
            return Either.right(x / y);
        }
    }
}
