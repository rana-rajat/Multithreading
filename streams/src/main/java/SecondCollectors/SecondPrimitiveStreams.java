package SecondCollectors;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecondPrimitiveStreams {
    public static void main(String[] args) {
        Integer[] numb = {1, 2, 3, 4, 5};
        Stream<Integer> stream1 = Arrays.stream(numb);
        //Above return type is Stream below is IntStream
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);
        //boxed means converted to wrapper class
        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

        IntStream.of(1, 2, 3, 4, 5);

        //below will give you a 5 random doubles
        DoubleStream doubles = new Random().doubles(5);
        System.out.println(doubles.boxed().toList());
        // System.out.println(doubles.sum());
        // System.out.println(doubles.min());
        // System.out.println(doubles.max());
        //System.out.println(doubles.average());
        //doubles.summaryStatistics();
        //doubles.mapToInt(x->(int) x+1);

        IntStream its = new Random().ints(5);
        System.out.println(its.boxed().toList());
    }
}
