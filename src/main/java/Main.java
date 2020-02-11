import by.epam.javatraining.matrix.service.ServiceHelperThread;

import java.util.Arrays;

public class Main implements Runnable {

    public void run() {

    }

    public static void main(String[] args) throws InterruptedException {
       for (int i = 0; i < 10; i++) {
           new ServiceHelperThread().start();
       }
    }
}
