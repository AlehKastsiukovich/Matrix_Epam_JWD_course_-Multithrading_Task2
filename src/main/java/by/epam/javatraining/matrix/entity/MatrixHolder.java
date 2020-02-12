package by.epam.javatraining.matrix.entity;

import by.epam.javatraining.matrix.util.MatrixInitializationDataReader;
import by.epam.javatraining.matrix.util.StringParser;

public class MatrixHolder {
    private int n;
    private int[][] matrix;

    private MatrixHolder() {
        MatrixInitializationDataReader reader = MatrixInitializationDataReader.getInstance();
        StringParser parser = StringParser.getInstance();
        n = parser.parseStringToMatrixSize(reader.readFile());
        matrix = new int[n][n];
    }

    private static class MatrixInstanceCreator {
        private static final MatrixHolder INSTANCE = new MatrixHolder();
    }

    public static MatrixHolder getInstance() {
        return MatrixInstanceCreator.INSTANCE;
    }

    public int getN() {
        return n;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
