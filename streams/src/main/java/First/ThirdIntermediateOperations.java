package First;

import java.util.Arrays;
import java.util.Collection;
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
        System.out.println(list.stream().map(String::toLowerCase).toList());

        //3 Sorted
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sortedCustomComparator = list.stream().sorted((b, c) -> b.length() - c.length());

        //Distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        //Limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

        //Skip -> it will skip the first 10 now in the below ex
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());

        //peak -> Performs an action on each element as it is consumed bascially in middle when you want to perform something
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

        //flatMap -> Handle stream of collections, lists, arrays where each element is itself a collection
        // flatten nested structured (eg. list within lists) so that they can be processed as a single sequence of elements
        //transform and flatten at the same time

        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        System.out.println(listOfList.get(1).get(1));//this is basic
        System.out.println(listOfList.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());
        System.out.println(listOfList.stream().flatMap(Collection::stream).map(String::toUpperCase).toList());

        List<String> stringList = Arrays.asList(
                "Hello World",
                "Java Streams are Powerful",
                "flatmap are powerful"
        );
        System.out.println(stringList.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).map(String::toLowerCase).toList());

    }
}
