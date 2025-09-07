package FifthExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FourthRemainingMethods {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future = service.submit(() -> 2 + 1);
        Integer i = future.get();
        System.out.println(i);
        service.shutdown();
        System.out.println(service.isShutdown());//returns true or false
        System.out.println(service.isTerminated());// returns true when the shutdown is completed and
        // all the task is completed wait for one second or thread.sleep(2) to return true


    }
}
