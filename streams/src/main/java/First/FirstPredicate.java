package First;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

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
        Consumer<Integer> consume = x -> System.out.println("Testing Consumer " + x);
        consume.accept(5);

        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> cd = x -> {
            for (int xz : x) {
                System.out.println(xz);
            }
        };
        cd.accept(list);

        //Supplier is just opposite of consumer it supplies the value and don't take any value
        Supplier<String> supply = () -> "Hello World";
        System.out.println(supply.get());

        //Combined example of all
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }

        // BiPredicate, BiFunction, BiConsumer
        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        isSumEven.test(2, 6);

        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        biFunction.apply("rajah", "rana");

        //We have Unary Operator it is work like when you have argument pass and return type are same like we use in function
        // so we can write one time instead of write two time  in unary
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println("Using Unary Operator " + unaryOperator.apply(5));

        //Binary Operator it is same as BiFunction, but it takes two argument and return type is same as argument
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println("Using Binary Operator " + binaryOperator.apply(5, 10));

        //Method Reference -> we can use methods without invoking and in place of lambda expression
        List<String> list1 = Arrays.asList("Ram", "Shyam", "Kam");
        list1.forEach(x-> System.out.println(x));
        list1.forEach(System.out::println);

        //Constructor reference
        List<String> list2 = Arrays.asList("A", "B", "C", "D");
        //stream we can convert a collection into stream and map lega kuch or fir dega
        List<MobilePhone> collect = list2.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList());
        List<MobilePhone> collect2 = list2.stream().map(MobilePhone::new).toList();
    }
}
class MobilePhone{
    String name;

    public MobilePhone(String x) {
    }
}
