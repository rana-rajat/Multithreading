package First;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class SixthParallelStream {
    //A type of stream that enables parallel processing of elements
    //Allowing multiple threads to process parts of the stream simultaneously
    //This can significantly improve performance for large data sets
    //because workload is distributed across multiple threads
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        //List<Long> factorials = list.stream().map(x -> factorial(x)).toList();
        List<Long> factorials = list.stream().map(SixthParallelStream::factorial).toList();
        //List<Long> factorials = list.stream().map(SixthParallelStream::factorial).sequential().toList();

        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken with Sequential Stream " + (endTime - startTime));

        //now with parallel stream
        startTime = System.currentTimeMillis();
        factorials = list.parallelStream().map(SixthParallelStream::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time Taken with Parallel Stream " + (endTime - startTime));
        //parallel stream are most effective for cpu-intensive or large datasets where tasks are independent
        //they made overhead for simple task or small datasets

        // Now We have Cumulative Sum
        // [1, 2, 3, 4 ,5] -> [1 ,3 ,6 ,10 ,15] example below
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sum = new AtomicInteger();
        //List<Integer> cumulativeSum = integers.parallelStream().map(x -> sum.addAndGet(x)).toList();
        List<Integer> cumulativeSum = integers.parallelStream().map(sum::addAndGet).toList();
        System.out.println("Expected Result [1 ,3 ,6 ,10 ,15 ]" );
        System.out.println("Actual Result with parallel stream "+ cumulativeSum);
        //so use only parallel stream when work are independent of each other

    }

    public static long factorial(int n) {
        long count = 1;
        for (int i = 1; i <= n; i++) {
            count *= i;
        }
        return count;
    }

}
