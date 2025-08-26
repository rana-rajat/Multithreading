package FourthLamdaExpression;

public class LambdaExpressiom {

    public static void main(String[] args) {
        Runnable task1 = () -> { // so task1 is the implementation class of Runnable and if
            System.out.println("Yhe le bhai");
        };
        // there is one statement we can remove the curly braces also
        //we can also created the thread without creating implementation as we're doing earlier
        Thread th = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {

            }
        });
        Thread bhai = new Thread(task1);
        bhai.start();
    }
}
