package FifthExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SecondFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        // use of Future is that if this method is successful or not and if return anything we can get from the future
        Future<Integer> future = service.submit(() -> 4);
        System.out.println(future.get());// future is returning and wait to complete the task and callable works above because returning something
        // future
        if (future.isDone()) {
            System.out.println("Yhe le");
        }
        // Another
        Future<?> submit = service.submit(() -> System.out.println("Here Runnable works because nothing Return and above callable used"));
        // but above there is return of Future so it returns only is done only but in above or callable its returns the data
        // but submit.get() also works only to complete the task and not return anything
        // so runnable nothing returns anything but returns Future which can be useful for us
        service.shutdown();
    }
}
