package lab2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class MatrixTest {

    @Test
    void Should_solve1() throws IOException { // nice name for test, bro!
        double[] B = new double[]{1, 1, 1};
        Matrix A = new Matrix(Paths.get("src/lab2/files/Test1.txt"));
        double[] result = new double[]{1, 1, 1};
        assertEquals(Arrays.toString(result), Arrays.toString(Matrix.solveSLAE(A, B)));
    }

    @Test
    void Should_solve2() throws IOException { // nice name for test, bro!
        double[] B = new double[]{1, 1, 1};
        Matrix A = new Matrix(Paths.get("src/lab2/files/Test2.txt"));
        double[] result = new double[]{-0.5, 1.5, -0.5};
        assertEquals(Arrays.toString(result), Arrays.toString(Matrix.solveSLAE(A, B)));
    }

    @Test
    void Should_solve3() throws IOException { // nice name for test, bro!
        double[] B = new double[]{1, 1, 1};
        Matrix A = new Matrix(Paths.get("src/lab2/files/Test3.txt"));
        double[] result = new double[]{-0.5, 1.5, -0.5};
        assertEquals(Arrays.toString(result), Arrays.toString(Matrix.solveSLAE(A, B)));
    }

    @Test
    void Should_throwWrongSize() throws IOException { // nice name for test, bro!
        NonSquareMatrixException exception = assertThrows(NonSquareMatrixException.class, () -> {
            new Matrix(Paths.get("src/lab2/files/Test4.txt"));
        });
        assertTrue(exception.getMessage().contains("Wrong matrix size"));
    }
}