package SecondCollectors;

import java.util.*;
import java.util.stream.Collectors;

public class FirstCollectorsDemo {
    //Collectors is a utility class like Arrays
    //provide set of methods to create common collectors
    public static void main(String[] args) {
        //1. Collecting to a List
        List<String> list = Arrays.asList("Anaa", "BoB", "Charlie", "David");
        List<String> a = list.stream()
                .filter(x -> x.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(a);

        //2. Collecting to a Set
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 3, 4);
        Set<Integer> collect = nums.stream().collect(Collectors.toSet());
        System.out.println("Collecting to a Set " + collect);

        //3. Collecting to a specified collection
        System.out.println("Collecting to a specified collection " + list.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>())));

        //4. Joining Strings will combine the whole list
        String concatenatesStreams = list.stream().map(String::toUpperCase).collect(Collectors.joining(" , "));
        System.out.println("Joining Strings will combine the whole list " + concatenatesStreams);

        //5. Summarizing Data
        // Generates statistical summary (count, sum , min, average, max)
        List<Integer> integers = Arrays.asList(2, 3, 4, 7, 11);
        IntSummaryStatistics stats = integers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        //6. Calculating Averages
        Double collect1 = integers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average " + collect1);

        //7. Counting
        Long counting = integers.stream().collect(Collectors.counting());
        System.out.println("Counting " + counting);

        //8. Grouping Elements
        List<String> words = Arrays.asList("Hello", "World", "Java", "streams", "collecting");
        System.out.println("Grouping with length " + words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println("Grouping with length and Joining  " + words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(","))));
        System.out.println("Grouping with length and counting the words " + words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> collect2 = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println("Grouping with length and converting it to the tree and finally counting  " + collect2);

        //9 Participating elements-> Partitions elements into two groups (true or false based on the predicate )
        System.out.println("Partitioning by words length " + words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

        //10 Mapping and collecting-> apply mapping function before collecting
        System.out.println("apply mapping function before collecting " + words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));

        //Example 1.Collecting Names by Length
        List<String> strList = Arrays.asList("Anaa", "BoB", "Charlie", "David");
        System.out.println("Example 1 with grouping " + strList.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println("Example 1 with Partitioning " + strList.stream().collect(Collectors.partitioningBy(x -> x.length() < 4)));

        //Example 2.Counting word occurrences
        String sentence = "Hello World Hello Ram Hello Shyam ";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        //Example 3.Partitioning even and odd numbers
        List<Integer> integersNew = Arrays.asList(2, 3, 4, 7, 11);
        System.out.println("Partitioning even and odd numbers "+integersNew.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        //Example 4.Summing value in a Map

    }
}
