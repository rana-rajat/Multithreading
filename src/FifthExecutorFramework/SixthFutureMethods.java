package FifthExecutorFramework;

import java.util.concurrent.*;

public class SixthFutureMethods {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 42;
        });
        Integer i = null;
        try {
            // so its waits for one second to complete the above thread and finally give the exception
            i = future.get(1, TimeUnit.SECONDS);
            System.out.println(future.isDone());// and it's not mean that task should complete it can also through exception
            System.out.println(i);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
