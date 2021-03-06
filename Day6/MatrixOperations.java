package lunmijo.days100.coding;
import java.util.Random;
/**
 * @author Lunmijo
 * April, 9, 2018
 * Last modified April, 14, 2018
 */
public class MatrixOperations {

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

    static double[][] get_minor(double[][] matrix, int row, int column) {
        int minorLength = matrix.length - 1;
        double[][] minor = new double[minorLength][minorLength];
        int deletingRow = 0;
        int deletingColumn;
        for(int i = 0; i <= minorLength; i++) {
            deletingColumn = 0;
            for(int j=0; j <= minorLength; j++) {
                if(i == row) {
                    deletingRow = 1;
                }
                else {
                    if(j == column) {
                        deletingColumn = 1;
                    }
                    else {
                        minor[i-deletingRow][j-deletingColumn] = matrix[i][j];
                    }
                }
            }
        }
        return minor;
    }
    static double algebraic_complement(double[][] matrix, int numberOfRow, int numberOfColumn) {
        int coefficient;
        if((numberOfRow+numberOfColumn) % 2 == 1){
            coefficient = -1;
        }
        else {
            coefficient = 1;
        }
        return (coefficient * find_determinant(get_minor(matrix,numberOfRow,numberOfColumn)));
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

    static double[][] matrix_to_diagonal_view(double[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix.length; j++) {
                    double coefficient = matrix[j][i] / matrix[i][i];
                    for (int k = i; k < matrix.length; k++) {
                        matrix[j][k] = matrix[j][k] - coefficient * matrix[i][k];
                    }
                }
            }
        return matrix;
    }

    public static double find_determinant(double[][] matrix) {
        double det = 1;
        if (matrix.length == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[1][0]*matrix[0][1];
        }
        else if (matrix.length == 3) {
            //triangle rule for finding determinant of matrix 3x3
            det =   matrix[0][0] * matrix[1][1] * matrix[2][2] +
                    matrix[1][0] * matrix[2][1] * matrix[0][2] +
                    matrix[0][1] * matrix[1][2] * matrix[2][0] -
                    matrix[0][2] * matrix[1][1] * matrix[2][0] -
                    matrix[1][2] * matrix[2][1] * matrix[0][0] -
                    matrix[0][1] * matrix[1][0] * matrix[2][2];
        }
        else if (matrix.length >= 8){
            for (int j = 0; j < matrix.length; j++) {
                double[][] triangleMatrix = new double[matrix.length][matrix.length];
                triangleMatrix = matrix;
                triangleMatrix = matrix_to_diagonal_view(triangleMatrix);
                det *= matrix[j][j];
            }
        }
        else {
            for (int j = 0; j < matrix.length; j++) {
                det += matrix[0][j] * algebraic_complement(matrix, 0, j);
            }

        }
        return det;
    }
    }
