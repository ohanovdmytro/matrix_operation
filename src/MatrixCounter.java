public class MatrixCounter {

    public static void main(String[] args) {
        Matrix matrix_first = new Matrix(new int[][] {
                {1, 2, 3, 1},
                {4, 5, 2, 4},
                {3, 4, 3, 9},
                {7, 8, 1, 9}
        });

        Matrix matrix_second = new Matrix(new int[][] {
                {2, 3, 9},
                {0, 1, 2},
                {3, 3, 4}
        });

        matrixSum_OOP_Style(matrix_first, matrix_second);

    }

    public static void matrixSum_OOP_Style(Matrix matrix1, Matrix matrix2) {
        Matrix matrix3 = matrix1.operation(matrix2, ((left, right) -> left + right));
        System.out.println(matrix3.toString());
    }

}
