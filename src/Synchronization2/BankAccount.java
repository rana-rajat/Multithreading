package Synchronization2;

//Locks in multithreading
public class BankAccount {
    private int balacne = 100;

    public synchronized void wihtdraw(int amount ) {
        System.out.println(Thread.currentThread().getName()+" is attempting to withdraw "+ amount);
        if(balacne >= amount){
            System.out.println(Thread.currentThread().getName()+" is going to withdraw");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
            balacne -= amount;
        }else{
            System.out.println("Sorry, not enough balance for "+ Thread.currentThread().getName());
        }

    }
}
