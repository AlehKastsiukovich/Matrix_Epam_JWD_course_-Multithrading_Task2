import by.epam.javatraining.matrix.entity.Matrix;
import by.epam.javatraining.matrix.service.MatrixService;

import java.util.Arrays;


public class Main extends Thread {

    public static void main(String[] args) {
        MatrixService service = new MatrixService();
        service.start();

    }
}
