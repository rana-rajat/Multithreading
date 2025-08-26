package FourthLamdaExpression;

public class LambdaExpressiom {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Yhe le bhai");
        };
        Thread bhai = new Thread(runnable);
        bhai.start();
    }
}
