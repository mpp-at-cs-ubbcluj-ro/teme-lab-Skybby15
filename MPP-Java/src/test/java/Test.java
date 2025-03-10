import com.google.common.collect.ImmutableSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    @org.junit.jupiter.api.Test
    public void test() {
        ImmutableSet<Integer> numbers = ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableSet<Integer> numbers2 = ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assert !numbers.equals(numbers2);
    }

    @org.junit.jupiter.api.Test

    public void test2() {
        ImmutableSet<Integer> numbers = ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertTrue(numbers.contains(1));
        assertEquals(10, numbers.size());
    }
}
