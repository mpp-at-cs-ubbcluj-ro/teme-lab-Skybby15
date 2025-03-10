package main;
import com.google.common.collect.ImmutableSet;

public class Main {
    public static void main(String[] args) {
        ImmutableSet<Integer> numbers = ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ImmutableSet<Integer> numbers2 = ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("Works");
    }
}