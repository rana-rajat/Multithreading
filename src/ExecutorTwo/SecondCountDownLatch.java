package ExecutorTwo;

import java.util.concurrent.*;

// CountDownLatch is used when one or more threads need to wait until a set of operations
// being performed by other threads are completed.
// It works like a gate: the gate is locked until the latch count reaches zero.
public class SecondCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 3; // Number of dependent services (threads) to wait for

        // Create a thread pool with fixed size equal to numberOfServices
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);

        // CountDownLatch initialized with numberOfServices
        // Main thread will wait until latch count reaches 0
        CountDownLatch latch = new CountDownLatch(numberOfServices);

        // Submitting 3 dependent services (tasks) to executor
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));

        // Main thread waits here until all services finish (count reaches zero)
        latch.await(5, TimeUnit.SECONDS); // block the main thread also we can also apply time here so its wait for that time and then main thread starts

        // Once all dependent services are finished, main thread resumes
        System.out.println("Main Thread continues after all services are done");

        // Shutdown the executor
        executorService.shutdown();
    }
}

// Dependent service which simulates some work
class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    // Constructor takes CountDownLatch to signal completion
    DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started");
            Thread.sleep(2000); // Simulating some work
        } finally {
            // Decrement the count of the latch once service is done
            latch.countDown();
        }
        return "ok";
    }
}
