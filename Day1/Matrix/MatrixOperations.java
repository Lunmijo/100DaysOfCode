package lunmijo.days100.coding;
/**
 * @author Lunmijo
 * April, 9, 2018

 */
public class MatrixOperations {

    public static double find_determinant(double[][] matrix) {
       double det = 0;
        if (matrix.length == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[1][0]*matrix[0][1];
        }
        else if (matrix.length == 3) {
            det =   matrix[0][0] * matrix[1][1] * matrix[2][2] +
                    matrix[1][0] * matrix[2][1] * matrix[0][2] +
                    matrix[0][1] * matrix[1][2] * matrix[2][0] -
                    matrix[0][2] * matrix[1][1] * matrix[2][0] -
                    matrix[1][2] * matrix[2][1] * matrix[0][0] -
                    matrix[0][1] * matrix[1][0] * matrix[2][2];
        }
        else {
            for (int j = 0; j < matrix.length; j++) {
                det += matrix[0][j] * algebraic_complement(matrix, 0, j);
            }
        }
        return det;
    }

    private static double algebraic_complement(double[][] matrix, int numberOfRow, int numberOfColumn) {
        int coefficient;
        if((numberOfRow+numberOfColumn) % 2 == 1){
            coefficient = -1;
        }
        else {
            coefficient = 1;
        }
        return (coefficient * find_determinant(get_minor(matrix,numberOfRow,numberOfColumn)));
    }

    private static double[][] get_minor(double[][] matrix, int row, int column) {
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
}
