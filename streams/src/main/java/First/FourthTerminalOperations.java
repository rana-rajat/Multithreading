package First;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FourthTerminalOperations {
    //as we know without terminal operation stream don't work
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        //1. collect
        System.out.println(list.stream().skip(1).toList());

        //2. for each
        list.stream().forEach(System.out::println);

        //3. Reduce ->Combines elements to produce a single result
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        Optional<Integer> reduced = list.stream().reduce(Integer::sum);
        System.out.println(reduce.get() + reduced.get());

        //4. AnyMatch, allMatch, None Match
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);
        boolean b1 = list.stream().allMatch(x -> x > 0);
        System.out.println(b1);
        boolean b2 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b2);

        //5. Findfirst, findany
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        //6. toArray -> when you want to convert any stream into Array
        Object[] array = Stream.of(1, 2, 3, 4, 5).toArray();

        //7. min/max
        System.out.println("max " + Stream.of(4, 5, 6, 3, 8, 34, 6, 43, 2, 4).max(Comparator.naturalOrder()));
        System.out.println("min " + Stream.of(4, 5, 6, 3, 8, 34, 6, 43, 2, 4).max((o1, o2) -> o2 - o1)); // yha bhe minimum he aayega kyuki
        // list descending order m ho jaayegi or sab se last number 2 hoga the use 01 -o2 for max

        //8. forEachOrdered
        List<Integer> integers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println("using for each for parallel stream");
        integers2.parallelStream().forEach(System.out::println);
        System.out.println("using for each Ordered for parallel stream");
        integers2.parallelStream().forEachOrdered(System.out::println);

        //Examples
        List<String> list1 = Arrays.asList("Anaa", "BoB", "Charlie", "David");
        System.out.println("trying " + list1.stream().filter(x -> x.length() > 3).toList());

        //Squaring and Sorting Numbers
        System.out.println(list.stream().map(x -> x * x).sorted().toList());

        //Reduced sum of numbers
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("ptane " + integers.stream().map(x -> x + x).toList());
        //correct is this above one double the value only
        System.out.println("Correct" + integers.stream().reduce(Integer::sum).get());

        //Example: Counting characters of elements
        String str = "Hello World";
        // we cant apply stream on the string so we have chars .filter which enable to apply the filter method
        System.out.println(str.chars().filter(x -> x == 'l').count());

        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4, 3, 2, 5, 6, 7);
        System.out.println("Yhe le " + integers1.stream().filter(x -> x == 3).count());

        //Example
        //streams cannot be used after a terminal operation has been called and give exception
        Stream<String> st = list1.stream();
        st.forEach(System.out::println);
        st.map(String::toUpperCase).toList();//exception because terminal operation was already used before
    }
}
