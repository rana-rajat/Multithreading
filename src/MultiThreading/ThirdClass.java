package MultiThreading;

public class ThirdClass {

    public static void main(String[] args) {
        SynchronizationSecond sc = new SynchronizationSecond();

        ThreadClass t1 = new ThreadClass(sc);
        ThreadClass t2 = new ThreadClass(sc);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sc.getCount()+" Total count");


    }
}
