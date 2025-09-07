package ExecutorTwo;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// CountDownLatch is not reusable once the count reaches zero,
// but CyclicBarrier can be reused, making it useful for scenarios
// where threads need to wait for each other at a common barrier point.
public class ThirdCyclicBarrier {
    public static void main(String[] args) {
        int numberOfServices = 3; // Number of tasks/threads to synchronize
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        // CyclicBarrier is created for 3 threads.
        // Once all 3 threads reach the barrier, they are released to continue.
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfServices);

        // Submitting 3 tasks to executor service
        executorService.submit(new Depend(cyclicBarrier));
        executorService.submit(new Depend(cyclicBarrier));
        executorService.submit(new Depend(cyclicBarrier));

        // Shut down the executor (no new tasks will be accepted,
        // but submitted tasks will continue running)
        executorService.shutdown();

        // cyclic barrier don't block the main thread
        System.out.println("Main thread has submitted all tasks");

        // also reset barrier and other methods
//        cyclicBarrier.reset();
//        cyclicBarrier.getParties();
//        cyclicBarrier.getNumberWaiting();
    }
}

// Task class that simulates a service dependent on a CyclicBarrier
class Depend implements Callable<String> {
    final CyclicBarrier barrier;

    Depend(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started");

        // Simulating some work with sleep
        Thread.sleep(6000);

        // After finishing the work, the thread waits at the barrier
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");

        // Each thread calls await(), and only when all 'numberOfServices' threads
        // have reached here, they will be released together.
        barrier.await();

        // After barrier is crossed, thread resumes
        return "OK";
    }
}
