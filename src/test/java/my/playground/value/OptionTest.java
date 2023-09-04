package my.playground.value;

import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class OptionTest {

    @Test
    public void someAndNone() {
        Option<String> some = Option.of("Hello");
        Option<String> none = Option.of(null);

        assertEquals("Hello", some.get());
    }

    @Test
    public void flatMap() {
        Option<String> maybeFoo = Option.of("foo");
        Option<String> maybeBar = maybeFoo.map(s -> (String) null)
                .flatMap(Option::of)
                .map(s -> s.toUpperCase() + "bar");

        Option<String> maybeBar2 = maybeFoo.flatMap(s -> Option.of((String) null))
                .map(s -> s.toUpperCase() + "bar");

        assertTrue(maybeBar.isEmpty());
        assertTrue(maybeBar2.isEmpty());
    }
}
