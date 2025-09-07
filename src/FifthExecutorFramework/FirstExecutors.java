package FifthExecutorFramework;

import java.util.concurrent.*;

public class FirstExecutors {
    public static int factorial(int n) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            try {
                Thread.sleep(100);
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
        // Executor executor = Executors.newFixedThreadPool(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            Future<?> future = executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
        }
        executor.shutdown(); //to stop thread pool and after this no thread can be started will give exception
//        try {
//           blocks until all the tasks have executed after a shutdown request to
//           below we will wait for 100 seconds to complete executor shutdown if it is not move to next statement
//            executor.awaitTermination(100, TimeUnit.MICROSECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("Total Time " + (System.currentTimeMillis() - startTime));
    }
}

