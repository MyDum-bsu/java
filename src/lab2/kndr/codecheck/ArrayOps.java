package lab2.kndr.codecheck;

public class ArrayOps {
    /**
     * This method adds up the integer values in an array,
     * with the integer sum returned at the end of the method.
     *
     * @param values, an array of integers, may be positive or negative
     * @ return, the sum of the integers
     */
    public static int sumArray(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
