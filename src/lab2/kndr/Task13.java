package lab2.kndr;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task13 {


    public static int[] createArray() {
        int[] numbers = new int[49];
        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    public static int[] createArrayTicket(int[] array) {
        int[] resultNumbers = new int[6];
        for (int i = 0; i < 6; ++i) {
            int index = createIndex(array.length);
            resultNumbers[i] = array[index];
            array = deleteByIndex(array, index);
        }
        Arrays.sort(resultNumbers);
        return resultNumbers;
    }

    public static ArrayList<Integer> createArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 49; ++i) {
            numbers.add(i + 1);
        }
        return numbers;
    }

    public static ArrayList<Integer> createArrayListTicket(ArrayList<Integer> array) {
        ArrayList<Integer> resultNumbers = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            int index = createIndex(array.size());
            resultNumbers.add(array.remove(index));
        }
        Collections.sort(resultNumbers);
        return resultNumbers;
    }

    public static int[] deleteByIndex(int[] array, int index) {
// throws IndexOutOfBoundsException, ArrayStoreException, NullPointerException что делает каждый?
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - 1 - index);
        return newArray;
    }

    public static int createIndex(int upperbound) throws IllegalArgumentException {
        Random generator = new Random();
        return generator.nextInt(upperbound);
    }

    public static void main(String[] args) {
        int[] numbersCommon = createArray();
        System.err.println(Arrays.toString(createArrayTicket(numbersCommon)));

        ArrayList<Integer> numbersList = createArrayList();
        System.err.println(createArrayListTicket(numbersList));

    }
}
