package lab2.kndr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        createArrayListPascalTriangle(n).forEach(System.err::println);
        //System.err.println(createArrayListPascalTriangle(n)); это вместо предыдущей строчки
        Arrays.stream(createArrayPascalTriangle(n)).forEach(row -> System.err.println(Arrays.toString(row))); // расскажите, пожалуйста, как именно работает
//        Main.runner();

    }

    public static void runner() {
        //....
    }
    public static ArrayList<ArrayList<Integer>> createArrayListPascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> previousRow = new ArrayList<>();
        ArrayList<Integer> currentRow = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i == 0)
                currentRow.add(1);
            else {
                int index = 1;
                currentRow = new ArrayList<>();
                for (int j = 0; j < previousRow.size() + 1; ++j) {
                    if (j == 0 || j == previousRow.size()) {
                        currentRow.add(1);
                    } else {
                        currentRow.add(previousRow.get(index - 1) + previousRow.get(index));
                        index++;
                    }
                }
            }
            triangle.add(currentRow);
            previousRow = new ArrayList<>();
            previousRow.addAll(0, currentRow);
        }
        return triangle;
    }
    public static int[][] createArrayPascalTriangle(int n) {
        int[][] triangle = new int[n][];
        int[] previousRow = new int[0];
        int[] currentRow;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                currentRow = new int[]{1};
            } else {
                int index = 1;
                currentRow = new int[previousRow.length + 1];
                for (int j = 0; j < currentRow.length; j++) {
                    if (j == 0 || j == currentRow.length - 1) {
                        currentRow[j] = 1;
                    } else {
                        currentRow[j] = previousRow[index - 1] + previousRow[index];
                        index++;
                    }
                }
            }
            triangle[i] = currentRow;
            previousRow = currentRow;
        }
        return triangle;
    }
}
