package FifthExecutorTwo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//introduced in java 8 to handle asynchronous programming
public class FourthCompleteFuture {
    public static void main(String[] args) {
        CompletableFuture<String> completeFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception e) {
                System.out.println("exception" + e);
            }
            return "Ok";
        });
        // main thread don't wait for the thread and actually the above thread is demon thread also. for wait, we use the below
        String s = null;
        try {
            s = completeFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);
        System.out.println("Main");

    }
}
