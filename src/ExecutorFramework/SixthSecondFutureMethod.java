package ExecutorFramework;

import java.util.concurrent.*;

public class SixthSecondFutureMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 42;
        });
        //Also, we have future cancel if we want to cancel the execution for somehow then we can cancel with the method below
        //in below method there will be two scenarios if the above thread is running or not

        future.cancel(false);
        future.get();
        // future.cancel(true); remember this run's in the main method so it can run before and after the thread
        System.out.println(future.isCancelled()); // this return true when only future.cancel method call not depend on what we give inside it true or false or cancel it
        System.out.println(future.isDone()); // this returns true when somewhere future method is call to execute some method

    }
}
