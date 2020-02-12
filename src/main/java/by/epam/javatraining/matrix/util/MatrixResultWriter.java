package by.epam.javatraining.matrix.util;

import by.epam.javatraining.matrix.entity.MatrixHolder;
import by.epam.javatraining.matrix.service.ServiceHelperThread;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MatrixResultWriter implements Runnable {
    private final String filePath;

    {
        ClassLoader classLoader = getClass().getClassLoader();
        filePath = classLoader.getResource("result.txt").getPath();
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public void run() {
        MatrixHolder matrixHolder = MatrixHolder.getInstance();
        List<Integer> resultList = ServiceHelperThread.getListOfSumResult();
        writeMatrixAndSumResultToFile(resultList, matrixHolder.getMatrix());
    }

    private static class MatrixResultWriterHolder {
        private static final MatrixResultWriter writer = new MatrixResultWriter();
    }

    public static MatrixResultWriter getInstance() {
        return MatrixResultWriterHolder.writer;
    }

    public void writeMatrixAndSumResultToFile(List<Integer> listOfSums, int[][] matrix) {
        StringParser parser = StringParser.getInstance();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(parser.parseListToString(listOfSums));
            listOfSums.removeAll(listOfSums);
            bufferedWriter.append("\n");
            bufferedWriter.write(parser.parseMatrixToString(matrix));
            bufferedWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

