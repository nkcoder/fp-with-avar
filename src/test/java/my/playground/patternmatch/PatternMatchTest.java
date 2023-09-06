package my.playground.patternmatch;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static io.vavr.API.*;
import static io.vavr.Predicates.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternMatchTest {

    @Test
    public void testBasicPatterns() {
        int num = 2;
        String s = Match(num).of(
                Case($(1), "One"),
                Case($(2), "Two"),
                Case($(), "Others")
        );
        assertEquals("Two", s);
    }

    @Test
    public void testPredicate() {
        List<Integer> nums = List.of(2, 4, 6, 8);
        String result = Match(nums).of(
                Case($(isNull()), "Null"),
                Case($(forAll(x -> x % 2 == 0)), "All even"),
                Case($(), "Has Odd")
        );

        assertEquals("All even", result);
    }

    @Test
    public void testNamedParameters() {
        Object amount = 50;
        Number num = Match(amount).of(
                Case($(instanceOf(Integer.class)), i -> i + 1),
                Case($(instanceOf(Double.class)), d -> d * (1 + 0.1)),
                Case($(), o -> {
                    throw new NumberFormatException();
                })
        );

        assertEquals(51, num);
    }


}


