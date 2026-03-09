import java.lang.Thread;
import java.lang.InterruptedException;

public class Second {
    static volatile Runnable lambda = null;
    public static void main(String[] args) throws Exception {
        Thread A = new Thread(() -> { lambda.run(); });
        Thread B = new Thread(() -> {
            try {
                A.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        lambda = () -> {
            try {
                B.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        A.start(); B.start();

        try {
            A.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            B.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}