package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SeventhScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println("Scheduled After 5 Seconds"), 5, TimeUnit.SECONDS);

        // Also we have
        ScheduledExecutorService scheduler2 = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(()-> System.out.println("Task Executed Every five second"),2,3,TimeUnit.SECONDS);
        scheduler.shutdown();
        scheduler2.shutdown();
    }
}
