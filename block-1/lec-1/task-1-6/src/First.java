import java.lang.Thread;
import java.lang.InterruptedException;

public class First {
    public static  void main(String[] args) throws InterruptedException {
        Thread A = new Thread(() -> {

            Thread B = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }});

            Thread C = new Thread(() -> {
                try {
                    B.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }});

            B.start(); C.start();

            try {
                B.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                C.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        A.start();
        try {
            A.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}