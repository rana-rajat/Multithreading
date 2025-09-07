package FifthExecutorTwo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FourthCompleteFutureSecond {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception e) {
                System.out.println("exception" + e);
            }
            return "Ok";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception e) {
                System.out.println("exception" + e);
            }
            return "Ok";
        });
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(f1, f2);// Returns a new CompletableFuture that is completed when all of them given CompletableFutures complete.
        completableFuture.join();
        //completableFuture.get();// difference is we have to apply the exception here but in join we don't need to do so
    }
}
