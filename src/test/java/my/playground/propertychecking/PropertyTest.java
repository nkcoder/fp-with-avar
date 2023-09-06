package my.playground.propertychecking;

import io.vavr.test.Arbitrary;
import io.vavr.test.Gen;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

public class PropertyTest {

    @Test
    public void testArbitrary() {
        Arbitrary<Integer> ints = Arbitrary.integer();
        Property.def("square(int) > 0")
                .forAll(ints)
                .suchThat(i -> i * i >= 0)
                .check()
                .assertIsSatisfied();


        Arbitrary<Integer> nums = Arbitrary.ofAll(Gen.choose(1, 10));
        Property.def("x >= 5")
                .forAll(nums)
                .suchThat(x -> x > 5)
                .check()
                .assertIsFalsified();
    }

}
