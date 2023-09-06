package my.playground.value;

import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import static my.playground.value.EitherContainer.divide;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EitherTest {

    @Test
    public void shouldReturnRight() {
        Either<String, Integer> result = divide(100, 3);

        assertTrue(result.isRight());
        assertEquals(33, result.get());
    }

    @Test
    public void shouldReturnLeft() {
        Either<String, Integer> result = divide(5, 0);
        assertTrue(result.isLeft());
        assertEquals("Error: divide by zero", result.getLeft());
    }


}
