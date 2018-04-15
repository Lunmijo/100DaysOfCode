package lunmijo.days100.coding;
import java.util.Random;
/**
 * @author Lunmijo
 * April, 9, 2018
 * Last modified April, 14, 2018

 */
public final class GeneralMatrixOperations {

    private GeneralMatrixOperations() { }
    //range is a maximum element number in matrix
    public static double[][] createRandIntMatrix(int numberOfRows, int numberOfColumns, int range) {
        double[][] matrix;
        Random random = new Random();
        matrix = new double[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                matrix[i][j] = random.nextInt(range);
            }
        }
        return matrix;
    }
    static int min_element_in_row(double[][] matrix, int rowNumber) {
        int minElementPosition = 0;
        for (int j = 1; j < matrix.length-1; j++) {
            if (matrix[rowNumber][j] < matrix[rowNumber][j+1] && matrix[rowNumber][j] != 0) {
                minElementPosition = j;
            }
        }
        return minElementPosition;
    }

    public static double[][] swap_columns(int numberOfColumnToSwap, int numberOfColumnFromSwap, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                double temp = matrix[i][numberOfColumnToSwap];
                matrix[i][numberOfColumnToSwap] = matrix[i][numberOfColumnFromSwap];
                matrix[i][numberOfColumnFromSwap] = temp;
            }
        }
        return matrix;
    }

    public static double[][] swap_rows(int numberOfRowToSwap, int numberOfRowFromSwap, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                double temp = matrix[numberOfRowToSwap][j];
                matrix[numberOfRowToSwap][j] = matrix[numberOfRowFromSwap][j];
                matrix[numberOfRowFromSwap][j] = temp;
            }
        }
        return matrix;
    }

}
