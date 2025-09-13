package First;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ThirdIntermediateOperations {
    //intermediate operations transforms one stream into another stream
    //they are lazy meaning they don't execute until a terminal operation is invoked
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Aakshit", "Ram", "Shyam", "Ghanshyam", "Aakshit");

        //First method Filter
        //where count is a terminal operator and without it there will be no result we have to use the terminal operator to get the result
        System.out.println(list.stream().filter(x -> x.startsWith("A")).count());

        //2 Operation or Map
        System.out.println(list.stream().map(x -> x.toLowerCase()).toList());
        System.out.println(list.stream().map(String::toLowerCase));

        //3 Sorted
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sortedCustomComparator = list.stream().sorted((b, c) -> b.length() - c.length());

        //Distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        //Limit
        System.out.println(Stream.iterate(1,x->x+1).limit(100).count());

        //Skip -> it will skip the first 10 now in the below ex
        System.out.println(Stream.iterate(1,x->x+1).skip(10).limit(100).count());

    }
}
