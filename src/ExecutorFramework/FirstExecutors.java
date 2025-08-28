package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstExecutors {
    public static int factorial(int n) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count *= i;
        }
        return count;
    }

    public static void main(String[] args) {
        // with MultiThreading
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
        }
        executor.shutdown();
        System.out.println("Total Time " + (System.currentTimeMillis() - startTime));
    }
}

