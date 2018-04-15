package lunmijo.days100.coding;

public class TestMatrix {
    public static void main(String[] args) {
        double[][] matrix;
        int size = 4;
        System.out.print("Start matrix:\n");
        matrix = GeneralMatrixOperations.createRandIntMatrix(size, size, 6);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        matrix = SquareMatrixOperations.matrix_to_diagonal_view(matrix);
        System.out.print("\nResult matrix:\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }
        double determinant = SquareMatrixOperations.find_determinant(matrix);
        System.out.print('\n' + determinant);
    }
}
