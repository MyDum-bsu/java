package lab2;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private final double[][] matrix;
    private int rows;
    private int cols;

    public Matrix(Path path) throws IOException, NonSquareMatrixException {
        readMatrixSizeFromFile(path);
        matrix = new double[rows][cols];
        readMatrixFromFile(path);
    }

    Matrix(Matrix A) {
        this.matrix = new double[A.rows][A.cols];
        this.rows = A.rows;
        this.cols = A.cols;
        for (int i = 0; i < A.rows; i++) {
            if (A.cols >= 0) {
                System.arraycopy(A.matrix[i], 0, this.matrix[i], 0, A.cols);
            }
        }
    }

    private void readMatrixSizeFromFile(Path path) throws IOException, NumberFormatException {
        Scanner scanner = new Scanner(path);
        String[] size = scanner.nextLine().split(" ");
        rows = Integer.parseInt(size[0]);
        cols = Integer.parseInt(size[1]);
    }

    private void readMatrixFromFile(Path path) throws IOException, IllegalArgumentException {
        Scanner scanner = new Scanner(path);
        int n = 0;
        scanner.nextLine();
        while (scanner.hasNextLine() && n < rows) {
            String[] arrayLine = scanner.nextLine().split(" ");
            if (arrayLine.length == 0) {
                break;
            }

//            //double[] row = Arrays.stream(line.split(" ")).mapToDouble(Double::parseDouble).toArray();
            if (arrayLine.length != cols) {
                throw new NonSquareMatrixException("Wrong matrix size");
            }

            for (int i = 0; i < cols; i++) {
                matrix[n][i] = Double.parseDouble(arrayLine[i]);
            }
            n++;
            if (n == rows && scanner.hasNextLine()) {
                throw new NonSquareMatrixException("Wrong matrix size");
            }
        }
    }

    private static Pair<Matrix, double[]> getTriangle(Matrix A, double[] B) throws IndexOutOfBoundsException {
        double ratio;
        Matrix triangularMatrix = new Matrix(A);
        double[] newB = new double[B.length];
        System.arraycopy(B, 0, newB, 0, B.length);
        int n = A.rows;

        for (int i = 0; i < n - 1; i++) {
            if (A.matrix[i][i] == 0) {
                int index = findNonZeroRow(triangularMatrix, i);
                if (index == -1) {
                    throw new IndexOutOfBoundsException("Unsolvable system");
                }
                changeRows(triangularMatrix, newB, i, index);
            }

            for (int j = i + 1; j <= n - 1; j++) {
                ratio = triangularMatrix.matrix[j][i] / triangularMatrix.matrix[i][i];
                for (int k = i; k < n; k++) {
                    triangularMatrix.matrix[j][k] -= ratio * triangularMatrix.matrix[i][k];
                }
                newB[j] -= newB[i] * ratio;
            }
        }
        return new Pair<>(triangularMatrix, newB);
    }

    public static double[] solveSLAE(Matrix A, double[] B) throws IllegalArgumentException {
        if (A.cols != A.rows) {
            throw new IllegalArgumentException("Matrix should be squared");
        }
        double[] solution = new double[A.rows];
        Pair<Matrix, double[]> pair = getTriangle(A, B);
        int n = A.rows;
        solution[n - 1] = pair.getSecond()[n - 1] / pair.getFirst().matrix[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            solution[i] = pair.getSecond()[i];
            for (int j = n - 1; j > i; j--) {
                solution[i] -= solution[j] * pair.getFirst().matrix[i][j];
            }
            solution[i] /= pair.getFirst().matrix[i][i];
        }
        return solution;
    }

    public void printExtendedMatrix(double[] B) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("| " + B[i]);
            System.out.println();
        }
    }

    private static int findNonZeroRow(Matrix A, int col) {
        for (int i = col; i < A.rows; i++) {
            if (A.matrix[i][col] != 0) {
                return i;
            }
        }
        return -1;
    }

    private static void changeRows(Matrix A, double[] B, int r1, int r2) throws IndexOutOfBoundsException {
        if (r1 >= A.rows || r1 < 0 || r2 < 0 || r2 >= A.rows) {
            throw new IndexOutOfBoundsException("Illegal index of rows");
        }
        double[] tempRow = new double[A.cols];
        System.arraycopy(A.matrix[r1], 0, tempRow, 0, A.cols);
        System.arraycopy(A.matrix[r2], 0, A.matrix[r1], 0, A.cols);
        A.matrix[r2] = tempRow;

        double temp = B[r1];
        B[r1] = B[r2];
        B[r2] = temp;
    }

    public static void run(Path path) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        double[] B = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            try {
                B[i] = Double.parseDouble(s[i]);
            } catch (NumberFormatException e) {
                System.err.println("wrong input:" + e.getLocalizedMessage());
                System.exit(2);
            }
        }
        Matrix m = null;
        try {
            m = new Matrix(path);
        } catch (NonSquareMatrixException | NumberFormatException | IOException e) {
            System.err.println("wrong input:" + e.getLocalizedMessage());
            System.exit(2);
        }

        if (B.length != m.matrix.length) {
            System.err.println("unequal matrix and vector size");
            System.exit(2);
        }
        m.printExtendedMatrix(B);
        System.out.println();
        double[] result = solveSLAE(m, B);
        System.out.println(Arrays.toString(result));
    }
}
