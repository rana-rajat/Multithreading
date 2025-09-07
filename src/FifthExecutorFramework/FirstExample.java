package FifthExecutorFramework;

public class FirstExample {
    public static int factorial(int n) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count *= i;
        }
        return count;
    }
// we are manually doing thread creation and no use of already created threads
    public static void main(String[] args) {
        //without multi
        for (int i = 1; i < 10; i++) {
            System.out.println(factorial(i));
        }
        // with MultiThreading
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for (int i = 1; i < 10; i++) {
            int finalI = i; // need to declare the final details are below
            threads[i - 1] = new Thread(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
            threads[i - 1].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // without threading taking 9 seconds now its taking only 1 second
        // without join the below print ln will start before thread starts
        System.out.println("Total Time " + (System.currentTimeMillis() - startTime));
    }
}
//Here, i is a loop variable. What happens is:
//
//The lambda (() -> {}) doesn’t run immediately.
//
//It gets executed later when the thread starts.
//
//By that time, the loop may have already incremented i — possibly all the way to 10.
//
//So instead of each thread capturing its own i, they all may end up using the final value of i (10) when they finally run.

//Each iteration creates a new variable finalI, which holds the current value of i.
//
//That value is fixed (not changed anymore).
//
//Each thread captures its own finalI.
//
//No matter when the thread executes, it always sees the correct value.
