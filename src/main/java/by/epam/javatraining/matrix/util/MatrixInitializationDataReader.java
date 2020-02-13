package by.epam.javatraining.matrix.util;

import by.epam.javatraining.matrix.exception.UtilException;
import java.io.BufferedReader;;
import java.io.FileReader;
import java.io.IOException;

public class MatrixInitializationDataReader {
    private final String path;

    public MatrixInitializationDataReader() {
        ClassLoader classLoader = getClass().getClassLoader();
        path = classLoader.getResource("data.txt").getPath();
    }

    private static class MatrixInitializationDataReaderHolder {
        private static final MatrixInitializationDataReader instance = new MatrixInitializationDataReader();
    }

    public static MatrixInitializationDataReader getInstance() {
        return MatrixInitializationDataReaderHolder.instance;
    }

    public String readFile() throws UtilException {
        String data = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            data = bufferedReader.readLine();
        } catch (IOException e) {
            throw new UtilException(e);
        }

        return data;
    }
}
