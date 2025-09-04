package ExecutorFramework;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates the use of ScheduledExecutorService for:
 * 1. One-time scheduled tasks.
 * 2. Periodic tasks using fixed-rate scheduling.
 * 3. Periodic tasks using fixed-delay scheduling.
 */
public class SeventhScheduledExecutorService {

    public static void main(String[] args) {

        // ============================================================
        // --- One-Time Scheduled Task ---
        // ============================================================
        System.out.println("--- One-Time Scheduled Task ---");

        ScheduledExecutorService singleTaskScheduler = Executors.newScheduledThreadPool(1);

        System.out.println("Task scheduled to run in 5 seconds.");
        singleTaskScheduler.schedule(() ->
                        System.out.println("One-time task executed after 5 seconds."),
                5, TimeUnit.SECONDS);

        // Shutdown after scheduling (waits for the one-time task to complete)
        singleTaskScheduler.shutdown();
        System.out.println("One-time scheduler initiated shutdown.");


        // ============================================================
        // --- Fixed-Rate Scheduled Task ---
        // ============================================================
        System.out.println("\n--- Fixed-Rate Scheduled Task ---");

        ScheduledExecutorService periodicTaskScheduler = Executors.newScheduledThreadPool(1);
        AtomicInteger fixedRateCounter = new AtomicInteger(0);

        // Schedule a task to run every 3 seconds, after an initial 2-second delay
        System.out.println("Periodic task scheduled to run every 3 seconds after an initial 2 second delay.");
        periodicTaskScheduler.scheduleAtFixedRate(() -> {
            int count = fixedRateCounter.incrementAndGet();
            System.out.println("Fixed-Rate task execution #" + count);
        }, 2, 3, TimeUnit.SECONDS);


        // ============================================================
        // --- Fixed-Delay Scheduled Task ---
        // ============================================================
        System.out.println("\n--- Fixed-Delay Scheduled Task ---");

        AtomicInteger fixedDelayCounter = new AtomicInteger(0);

        // Schedule a task with fixed delay of 4 seconds
        ScheduledFuture<?> scheduledNew = periodicTaskScheduler.scheduleWithFixedDelay(() -> {
            int count = fixedDelayCounter.incrementAndGet();
            System.out.println("Fixed-Delay task execution #" + count + " -> yhe Le");
        }, 4, 4, TimeUnit.SECONDS);


        // ============================================================
        // --- Controlled Shutdown ---
        // ============================================================
        // Schedule a shutdown after 20 seconds
        periodicTaskScheduler.schedule(() -> {
            System.out.println("\nInitiating shutdown for periodic scheduler after 20 seconds.");
            scheduledNew.cancel(false); // Cancel the fixed-delay task
            periodicTaskScheduler.shutdown();
            System.out.println("Periodic scheduler shutdown initiated.");
        }, 20, TimeUnit.SECONDS);
    }
}
