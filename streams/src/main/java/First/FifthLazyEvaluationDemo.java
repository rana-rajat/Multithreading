package First;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FifthLazyEvaluationDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Anaa", "BoB", "Charlie", "David");
        Stream<String> stream = list.stream().filter(x -> {
            System.out.println(x);
            return x.length() > 3;
        });
        System.out.println("Before terminal Operator");

        List<String> collect = stream.collect(Collectors.toList());
        System.out.println("After terminal Operator");

        System.out.println(collect);
    }
}
