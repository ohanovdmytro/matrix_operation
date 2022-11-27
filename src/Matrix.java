import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class Matrix {

    private int[][] input;

    public Matrix (int[][] input) {
        this.input = input;
    }

    public Matrix (int width, int height) {
        input = new int[width][height];
        for (int i = 0; i < width; i++) {
            input[i] = new int [height];
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(input);
    }

    public void set (int x, int y, int value) {
        if (outOf(x, y)){
            return;
        }
        input[x][y] = value;
    }

    public int get (int x, int y) {
        if (outOf(x, y)){
            return 0;
        }
        return input[x][y];
    }

    private boolean outOf(int x, int y) {
        return x < 0 || x >= width() || y < 0 || y >= height();
    }

    public int width() {
        if (input == null) {
            return 0;
        }
        return input.length;
    }

    public int height() {
        if (width() == 0) {
            return 0;
        }
        return input[0].length;
    }

    public Matrix operation (Matrix matrix, IntBinaryOperator operator) {
        int width = Math.max(width(), matrix.width());
        int height = Math.max(height(), matrix.height());
        Matrix result = new Matrix(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int left = get(x, y);
                int right = matrix.get(x, y);
                result.set(x, y, operator.applyAsInt(left, right));
            }
        }
        return result;
    }

    public Matrix lambdaSum (Matrix matrix) {
        return operation(matrix, (left, right) -> left + right);
    }

}