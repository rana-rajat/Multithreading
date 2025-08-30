package ExecutorFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FifthInvokeMethod {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = () -> {
            System.out.println("Task1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
        List<Future<Integer>> futures = executorService.invokeAll(list);
        executorService.shutdown();
    }
}
