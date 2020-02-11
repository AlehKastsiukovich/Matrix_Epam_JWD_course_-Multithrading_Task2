package by.epam.javatraining.matrix.util;

import by.epam.javatraining.matrix.entity.MatrixHolder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtSumResultAndMatrixWriter {
    private String filePath;

    public void writeMatrixAndSumResultToFile(String result, int[][] matrix) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(result);
            bufferedWriter.append(" - ");
            bufferedWriter.write(String matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
