package ExecutorFramework;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates the use of ScheduledExecutorService for both one-time and
 * fixed-rate periodic tasks.
 */
public class SeventhScheduledExecutorService {

    public static void main(String[] args) {
        // --- One-Time Scheduled Task ---
        System.out.println("--- One-Time Scheduled Task ---");
        // Create a scheduled executor with a single thread.
        ScheduledExecutorService singleTaskScheduler = Executors.newScheduledThreadPool(1);

        // Schedule a task to run once after a 5-second delay.
        System.out.println("Task scheduled to run in 5 seconds.");
        singleTaskScheduler.schedule(() -> {
            System.out.println("One-time task executed after 5 seconds.");
        }, 5, TimeUnit.SECONDS);

        // A one-time task will always be completed before a shutdown() call
        // if the shutdown() is called after the task is scheduled. The scheduler
        // will wait for the task to finish.
        singleTaskScheduler.shutdown();
        System.out.println("One-time scheduler initiated shutdown.");

        System.out.println("\n--- Fixed-Rate Scheduled Task ---");
        // --- Fixed-Rate Periodic Task with Controlled Shutdown ---
        ScheduledExecutorService periodicTaskScheduler = Executors.newScheduledThreadPool(1);
        AtomicInteger taskCounter = new AtomicInteger(0);

        // Schedule a task to run every 3 seconds, starting after an initial delay of 2 seconds.
        // This is useful for tasks that should be executed at a constant interval.
        System.out.println("Periodic task scheduled to run every 3 seconds after an initial 2 second delay.");
        periodicTaskScheduler.scheduleAtFixedRate(() -> {
            int count = taskCounter.incrementAndGet();
            System.out.println("Periodic task execution #" + count);
        }, 2, 3, TimeUnit.SECONDS);

        // Unlike a one-time task, a periodic task runs indefinitely. A direct `shutdown()`
        // call here would likely terminate the scheduler before the task can run even once.
        // Therefore, we need to schedule a separate task to control the shutdown.
        periodicTaskScheduler.schedule(() -> {
            System.out.println("\nInitiating shutdown for the periodic scheduler after 20 seconds.");
            periodicTaskScheduler.shutdown();
            System.out.println("Periodic scheduler shutdown initiated.");
        }, 20, TimeUnit.SECONDS);
    }
}