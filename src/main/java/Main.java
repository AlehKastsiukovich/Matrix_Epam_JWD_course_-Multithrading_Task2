import by.epam.javatraining.matrix.exception.ServiceException;
import by.epam.javatraining.matrix.service.MatrixService;
import by.epam.javatraining.matrix.service.ServiceHelperThread;
import org.apache.log4j.Logger;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        MatrixService service = MatrixService.getInstance();
        try {
            service.initMatrix();
        } catch (ServiceException e) {
            logger.error(e);
        }
        for (int i = 0; i < 30; i++) {
            new ServiceHelperThread().start();
        }
    }
}
