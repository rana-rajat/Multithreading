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
        System.out.println("Partitioning even and odd numbers " + integersNew.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        //Example 4.Reverse a string by loop
        String yhele = "Mohan";
        String[] splitted = yhele.split("");
        int start = 0;
        int end = yhele.length() - 1;
        while (start < end) {
            String temp = splitted[start];
            splitted[start] = splitted[end];
            splitted[end] = temp;
            start++;
            end--;

        }
        String join = String.join("", splitted);
        System.out.println("Printing the Reverse "+join);

        //Example 5.Summing Values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);
        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println(items.values().stream().collect(Collectors.summingInt(x->x)));

        //6. Create a map from Stream Elements
        List<String> lt = Arrays.asList("Anaa", "BoB", "Charlie", "David");
        System.out.println("Checking "+lt.stream().collect(Collectors.groupingBy(x->x,HashMap::new,Collectors.counting())));
        System.out.println("Using to map counting the word length of each "+lt.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));

        //7. Merge
        List<String> list3 = Arrays.asList(" Apple ", " Banana ", " Guava ", "Orange ", "Apple ");
        System.out.println("Using merge function "+ list3.stream().collect(Collectors.toMap(l->l , v-> 1 ,(x,y )->x+y)));

    }
}
