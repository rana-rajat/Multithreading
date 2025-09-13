package First;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondStreamDemo {
    public static void main(String[] args) {
        /* Stream is a sequence of elements supporting functional and declarative programming
         * Streams in Java (introduced in Java 8)
         * - Process collections in a functional and declarative style
         * - Simplify data processing
         * - Encourage functional programming
         * - Improve readability and maintainability
         * - Enable easy parallelism
         * Usage of Streams:
         * - Source,Intermediate operations,Terminal operation
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //traditional method
        int count = 0;
        for (int i : numbers) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
        // with streams
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());
        //diff methods to create the streams
        //From Arrays
        String[] array = {"A", "B", "C"};
        Stream<String> stream = Arrays.stream(array);
        //3 Using Stream of
        Stream<String> a = Stream.of("a", "b", "c");
        //Infinite Stream
        Stream<Integer> limit = Stream.generate(() -> 1).limit(100);
        //seed means starting point and will go infinite
        List<Integer> list2 = Stream.iterate(1, x -> x + 1).limit(100).toList();
        System.out.println(list2);

    }
}
