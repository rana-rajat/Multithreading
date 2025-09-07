package FifthExecutorTwo;

import java.util.concurrent.*;

public class First {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //here in this class we have to right every time future.get to complete every task and main thread will wait
        // we can also write invokeAll also, and then we have to pass the list so to escape all this we have count down latch
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(new DependService());
        Future<String> future2 = executorService.submit(new DependService());
        Future<String> future3 = executorService.submit(new DependService());
        Future<String> future4 = executorService.submit(() -> {
            System.out.println("yhe le");
            Thread.sleep(3000);
            return "Ok";
        });

        future1.get(); // waiting for future 1 to complete it
        future2.get();
        future3.get();
        future4.get();


        System.out.println("All dependent services finished. Starting main service ...");
        executorService.shutdown();
    }
}

class DependService implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started");
        Thread.sleep(2000);
        return "ok";
    }
}
