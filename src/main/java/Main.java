import by.epam.javatraining.matrix.entity.Matrix;
import by.epam.javatraining.matrix.service.MatrixService;

import java.util.Arrays;


public class Main extends Thread {

    public static void main(String[] args) {
        Matrix matrix = Matrix.getInstance();
        matrix.setN(5);
        MatrixService matrixService = new MatrixService();
        matrixService.setName("500");
        matrixService.start();

        try {
            matrixService.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < matrix.getMatrix().length; i++) {
            System.out.println(Arrays.toString(matrix.getMatrix()[i]));
        }

    }
}
