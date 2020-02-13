package by.epam.javatraining.matrix.validator;

public class Validator {

    private Validator() {
    }

    private static class ValidatorHolder {
        private static final Validator validator = new Validator();
    }

    public static Validator getInstance() {
        return ValidatorHolder.validator;
    }

    public boolean checkDataFromFile(String data) {
        if (data == null)
            return false;
        String[] initArray = data.split(" ");
        if (initArray.length != 2)
            return false;

        int matrixSize;
        try {
            matrixSize = Integer.parseInt(initArray[0]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (matrixSize < 1)
            return false;

        int numberOfThreads;
        try {
            numberOfThreads = Integer.parseInt(initArray[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (numberOfThreads < matrixSize && numberOfThreads % matrixSize != 0)
            return false;

        return true;
    }
}
