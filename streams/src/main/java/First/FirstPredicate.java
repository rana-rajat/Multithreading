package First;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FirstPredicate {
    public static void main(String[] args) {
        //is a functional interface (Boolean valued function) which converts a condition into a variable
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Testing Predicate " + isEven.test(4));

        Predicate<String> startsWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> endsWithT = x -> x.toLowerCase().endsWith("t");
        Predicate<String> result = startsWithA.and(endsWithT);
        System.out.println("Testing Predicate " + startsWithA.test("Aman"));
        System.out.println("Testing Predicate " + result.test("amit"));


        //predicate checks only the condition function also do some work

        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripleIt = x -> 3 * x;
        System.out.println("Using Function to do some work " + doubleIt.apply(4));
        System.out.println("Using Function to do some work " + doubleIt.andThen(tripleIt).apply(10));// both we can do and these are default method we have only one abstract method

        // Also we have which returns the same value which we provide all these have in streams
        Function<Integer, Integer> identity = Function.identity();
        Integer apply = identity.apply(5);
        System.out.println("Using identity in Function " + apply);

        // Now we have consumer which consumes only and don't return only consumes
        Consumer<Integer> consume = x -> System.out.println("Testing Consumer "+ x);
        consume.accept(5);

        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> cd = x -> {
            for (int xz : x) {
                System.out.println(xz);
            }
        };
        cd.accept(list);
    }
}
