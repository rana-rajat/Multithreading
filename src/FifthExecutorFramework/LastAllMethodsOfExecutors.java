package FifthExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class LastAllMethodsOfExecutors {

    public static void main(String[] args) {

        // FixedThreadPool: Creates a pool with a fixed number of threads.
        // At most 2 tasks will run in parallel, extra tasks will wait in a queue.
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // SingleThreadExecutor: Only 1 thread executes tasks sequentially.
        // Ensures tasks never overlap and always run in order.
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        // ScheduledThreadPool: Allows scheduling tasks with delay or periodically.
        // Good for repeated jobs (cron-like tasks, timers, monitoring).
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        // CachedThreadPool: Creates threads as needed and reuses idle ones.
        // Suitable for many short-lived async tasks, handles when you don't know how many task can come.
        // if long task come here all cpu utilization works here also used when there is variable load.
        ExecutorService executorService2 = Executors.newCachedThreadPool();


    }

}
