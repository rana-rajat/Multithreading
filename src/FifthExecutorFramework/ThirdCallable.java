package FifthExecutorFramework;

import java.util.concurrent.Callable;

public class ThirdCallable implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(300);// no need to write the try catch already in the method signature
        return null;
    }
}
