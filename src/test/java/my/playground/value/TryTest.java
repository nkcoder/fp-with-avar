package my.playground.value;

import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TryTest {

    @Test
    public void tryTest() {
        Try<Integer> byZero = Try.of(() -> divide(5, 0));
        assertTrue(byZero.isFailure());

        Try<Integer> byZeroWithRecover = Try.of(() -> divide(8, 0))
                .recover(x -> Integer.MAX_VALUE);
        assertTrue(byZeroWithRecover.isSuccess());
        assertEquals(Integer.MAX_VALUE, byZeroWithRecover.get());

        Try<Integer> divide = Try.of(() -> divide(8, 2));
        assertEquals(4, divide.get());
    }

    private Integer divide(int x, int y) {
        return x / y;
    }
}
