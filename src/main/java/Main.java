import by.epam.javatraining.matrix.service.ServiceHelperThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            new ServiceHelperThread().start();
        }
    }
}
