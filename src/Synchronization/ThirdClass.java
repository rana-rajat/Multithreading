package Synchronization;

public class ThirdClass {

    public static void main(String[] args) {
        SynchronizationFirst sc = new SynchronizationFirst();

        SynchronizationSecond t1 = new SynchronizationSecond(sc);
        SynchronizationSecond t2 = new SynchronizationSecond(sc);
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
