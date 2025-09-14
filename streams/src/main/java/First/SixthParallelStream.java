package First;

import java.util.List;
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
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken with Sequential Stream "+ (endTime-startTime));

        //now with parallel stream
        startTime = System.currentTimeMillis();
        factorials = list.parallelStream().map(SixthParallelStream::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time Taken with Parallel Stream "+ (endTime-startTime));

    }
    public static long factorial(int n) {
        long count = 1;
        for (int i = 1; i <= n; i++) {
            count *= i;
        }
        return count;
    }
    //parallel stream are most effective for cpu-intensive or large datasets where tasks are independent
    //they made overhead for simple task or small datasets
}
