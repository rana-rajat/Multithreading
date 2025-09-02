package ExecutorFramework;

import java.util.concurrent.*;

public class SixthSecondFutureMethod {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit a Callable task
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                throw new RuntimeException("Task was interrupted", e);
            }
            System.out.println("Checking if codes comes here ");
            return 42;
        });

        // Main thread also waits for 1 second to run the above thread otherwise main thread run before external or above thread
        try {
            Thread.sleep(1000); // Ensures the Callable is already finished
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Attempt to cancel the task
        // cancel(true)  -> tries to interrupt if still running
        // cancel(false) -> will not interrupt if already running
        future.cancel(false);

        try {
            // After cancellation, calling get() will throw CancellationException
            Integer result = future.get();
            System.out.println("Task result: " + result);
        } catch (InterruptedException | ExecutionException | CancellationException e) {
            System.out.println("Exception while retrieving future result: " + e);
        }

        // Future state checks
        System.out.println("Is Cancelled? " + future.isCancelled());
        // true only if cancel() succeeded before completion
        System.out.println("Is Done? " + future.isDone());
        // true if the task completed, failed, or was cancelled

        executorService.shutdown();
    }
}
