package ExecutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FifthInvokeMethod {
    public static void main(String[] args) throws Exception {
        // Create a thread pool of size 2
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Define callable tasks
        Callable<Integer> callable1 = () -> {
            System.out.println("Task1 executed by " + Thread.currentThread().getName());
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task2 executed by " + Thread.currentThread().getName());
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task3 executed by " + Thread.currentThread().getName());
            return 3;
        };

        // Put tasks into a list
        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        // Submit all tasks together using invokeAll()
        List<Future<Integer>> futures = executorService.invokeAll(list);

        // Retrieve results
        for (Future<Integer> future : futures) {
            System.out.println("Result: " + future.get());
        }

        // Shutdown the executor
        executorService.shutdown();
    }
}
