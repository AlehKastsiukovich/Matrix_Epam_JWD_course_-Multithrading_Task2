import by.epam.javatraining.matrix.exception.ServiceException;
import by.epam.javatraining.matrix.service.MatrixService;
import by.epam.javatraining.matrix.service.ServiceHelperThread;

public class Main {

    public static void main(String[] args) {
        MatrixService service = MatrixService.getInstance();
        try {
            service.initMatrix();
        } catch (ServiceException e) {

        }

        for (int i = 0; i < 30; i++) {
            new ServiceHelperThread().start();
        }

    }
}
