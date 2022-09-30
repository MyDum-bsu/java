package lab2.kndr.codecheck;

public class ArrayOps3 {
    /**
     This method goes through the array of integers identified by
     the first parameter, while counting the number of occurrences
     of the second parameter, a single integer, within the array.
     @param theArray, an array of integers
     @param theInt, an integer whose occurrences within the array
     need to be counted
     @ return, the count of the occurrences of the integer represented
     by the second parameter in the array of integers.
     */
    public static int countOccurs(int[] theArray, int theInt)
    {
        int count = 0;

        for (int value : theArray) {
            if (value == theInt) {
                count++;
            }
        }
        return count;
    }
}
