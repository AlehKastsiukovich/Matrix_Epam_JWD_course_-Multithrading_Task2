import by.epam.javatraining.matrix.service.ServiceHelperThread;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ServiceHelperThread().start();
        }

    }
}
