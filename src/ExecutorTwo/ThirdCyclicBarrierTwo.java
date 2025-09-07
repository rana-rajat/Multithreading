package ExecutorTwo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// Main class to simulate starting multiple subsystems
public class ThirdCyclicBarrierTwo {
    public static void main(String[] args) {
        int numberOfSubsystems = 4;

        // CyclicBarrier with 4 parties (threads).
        // When all 4 reach the barrier, the final Runnable executes.
        CyclicBarrier barrier = new CyclicBarrier(numberOfSubsystems, new Runnable() {
            @Override
            public void run() {
                System.out.println("✅ All subsystems are up and running. System startup complete.");
            }
        });

        // Creating threads for each subsystem with different initialization times
        Thread webServerThread = new Thread(new Subsystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new Subsystem("Database", 4000, barrier));
        Thread cacheThread = new Thread(new Subsystem("Cache", 3000, barrier));
        Thread messagingServiceThread = new Thread(new Subsystem("Messaging Service", 3500, barrier));

        // Starting subsystem threads
        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();
    }
}

// Subsystem class implementing Runnable to simulate initialization work
class Subsystem implements Runnable {
    private final String name;
    private final int initializationTime;
    private final CyclicBarrier barrier;

    public Subsystem(String name, int initializationTime, CyclicBarrier barrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("🔹 " + name + " initialization started.");

            // Simulating work with sleep
            Thread.sleep(initializationTime);

            System.out.println("✅ " + name + " initialization complete. Waiting at barrier...");

            // Wait at the barrier until all subsystems are initialized
            barrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
