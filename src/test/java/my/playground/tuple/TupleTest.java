package my.playground.tuple;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TupleTest {

    @Test
    public void accessTupleElements() {
        Tuple2<String, Integer> java17 = Tuple.of("Java", 17);
        assertEquals("Java", java17._1);
        assertEquals(17, java17._2());
    }

    @Test
    public void mapTupleElements() {
        Tuple2<String, String> java17 = Tuple.of("Java", 17).map(
                s -> s + "!",
                String::valueOf
        );
        assertEquals("Java!", java17._1);
        assertEquals("17", java17._2);

        Tuple2<String, String> java17Again = Tuple.of("Java", 17).map(
                (s, i) -> Tuple.of(s + "!", String.valueOf(i))
        );
        assertEquals("Java!", java17Again._1);
        assertEquals("17", java17Again._2);
    }

    @Test
    public void transformTuple() {
        String java17 = Tuple.of("Java", 17).apply(
                (s, i) -> s + i + "!"
        );
        assertEquals("Java17!", java17);
    }
}
