package my.playground.function;

import io.vavr.*;
import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FunctionTest {

    @Test
    public void functionCreation() {
        Function2<Integer, Integer, Integer> sum = Function2.of(Integer::sum);
        assertEquals(10, sum.apply(2, 8));

        Function3<Integer, Integer, Integer, Integer> sum3 = (x, y, z) -> x + y + z;

        // equivalent to
        Function3<Integer, Integer, Integer, Integer> sum3WithOf = Function3.of(
                (x, y, z) -> x + y + z
        );

        assertEquals(6, sum3.apply(1, 2, 3));
        assertEquals(6, sum3.apply(1).apply(2).apply(3));
    }

    @Test
    public void functionComposition() {
        Function1<Integer, Integer> plusOne = x -> x + 1;
        Function1<Integer, Integer> multiply2 = x -> x * 2;

        Function1<Integer, Integer> andThen = plusOne.andThen(multiply2);
        Function1<Integer, Integer> compose = multiply2.compose(plusOne);

        assertSame(andThen.apply(5), compose.apply(5));
    }

    @Test
    public void functionLift() {
        Function2<Integer, Integer, Integer> divide = (x, y) -> x / y;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);

        assertEquals(Option.none(), safeDivide.apply(5, 0));
        assertEquals(Option.of(5), safeDivide.apply(5, 1));
    }

    @Test
    public void partialApplication() {
        Function5<Integer, Integer, Integer, Integer, Integer, Integer> sum = (a, b, c, d, e) -> a + b + c + d + e;
        Function2<Integer, Integer, Integer> sum6 = sum.apply(1, 2, 3);

        assertEquals(15, sum6.apply(4, 5));
        assertEquals(15, sum6.apply(4).apply(5));
    }

    @Test
    public void curring() {
        Function3<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        Function1<Integer, Function1<Integer, Integer>> add5 = sum.curried().apply(5);
        assertEquals(18, add5.apply(6).apply(7));
    }

    @Test
    public void memoization() {
        Function0<Double> random = Function0.of(Math::random).memoized();
        assertEquals(random.apply(), random.apply());
    }

}
