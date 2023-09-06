package my.playground.collections;

import io.vavr.collection.List;
import io.vavr.collection.Stream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CollectionTest {

    @Test
    public void testForList() {
        Number sum = List.of(1, 2, 3, 4, 5)
                .map(x -> x * 2)
                .distinct()
                .filter(x -> x > 5)
                .sum();
        assertEquals(24, sum.intValue());

        List<Integer> nums = List.range(0, 10).dropWhile(x -> x <= 5);
        assertEquals(List.of(6, 7, 8, 9), nums);
    }

    @Test
    public void testForStream() {
        Stream<String> nums = Stream.from(1).map(String::valueOf);
        assertFalse(nums.hasDefiniteSize());
    }

}
