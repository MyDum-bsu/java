package lab2.kndr.codecheck;

public class ArrayOps4 {
    /**
     This method sums up both rows of a two-dimensional array
     (the only parameter to the method) and returns the greater sum.
     @param theArray, a 2-D array of integers
     @return, the greater row sum
     */
    public static int bigSum(int[][] theArray)
    {
        int sum = 0;
        for (int[] row : theArray) {
            if (sum < ArrayOps.sumArray(row)) {
                sum = ArrayOps.sumArray(row);
            }
        }
        return sum;
    }
}
