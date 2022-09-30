package lab2.kndr;

import java.util.ArrayList;
import java.util.Scanner;

public class Task14 {

    static int MAX = 100;

    public static void main(String[] args) {
        String buffer = "buffer";
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[MAX][MAX];
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
        int rows = 0;
        int columns = 0;
        while (!buffer.equals("")){
            buffer = scanner.nextLine();
            String[] numbers = buffer.split(" ");
            if(!buffer.equals("")){
                columns = numbers.length;
                ArrayList<Integer> tmp = new ArrayList<>();
                for(int i = 0; i < numbers.length; i++){
                    array[rows][i] = Integer.parseInt(numbers[i]);
                    tmp.add(i, Integer.parseInt(numbers[i]));
                }
                arrList.add(rows, tmp);
                rows++;
            }
        }
        for(int size = 2; size <= Math.min(rows, columns); size++){
            for(int x = 0; x <= rows - size; x++){
                for(int y = 0; y <= columns - size; y++){
                    if(checkMagicSquare(x, y, size, array)){
                        System.out.printf("Magic square: %d, %d, %d, %d\n", x, y, x + size - 1, y + size - 1);
                    }
                    if(checkMagicSquare(x, y, size, arrList)){
                        System.out.printf("Magic square by arrayList: %d, %d, %d, %d\n", x, y, x + size - 1, y + size - 1);
                    }
                }
            }
        }
    }

    public static boolean checkMagicSquare(int x0, int y0, int size, int[][] array){
        int standard = 0;
        for(int i = 0; i < size; i++){
            standard += array[x0][y0 + i];
        }
        // Check rows
        int tmpSum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                tmpSum += array[x0 + i][y0 + j];
            }
            if(standard != tmpSum){
                return false;
            }
            tmpSum = 0;
        }
        // Check columns
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                tmpSum += array[x0 + j][y0 + i];
            }
            if(standard != tmpSum){
                return false;
            }
            tmpSum = 0;
        }
        // Check diagonals
        for(int i = 0; i < size; i++){
            tmpSum += array[x0 + i][y0 + i];
        }
        if(standard != tmpSum){
            return false;
        }
        tmpSum = 0;
        for(int i = 0; i < size; i++){
            tmpSum += array[x0 + i][y0 + size - 1 -i];
        }
        return standard == tmpSum;
    }

    public static boolean checkMagicSquare(int x0, int y0, int size, ArrayList<ArrayList<Integer>> array){
        int standard = 0;
        for(int i = 0; i < size; i++){
            standard += array.get(x0).get(y0 + i);
        }
        // Check rows
        int tmpSum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                tmpSum += array.get(x0 + i).get(y0 + j);
            }
            if(standard != tmpSum){
                return false;
            }
            tmpSum = 0;
        }
        // Check columns
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                tmpSum += array.get(x0 + j).get(y0 + i);
            }
            if(standard != tmpSum){
                return false;
            }
            tmpSum = 0;
        }
        // Check diagonals
        for(int i = 0; i < size; i++){
            tmpSum += array.get(x0 + i).get(y0 + i);
        }
        if(standard != tmpSum){
            return false;
        }
        tmpSum = 0;
        for(int i = 0; i < size; i++){
            tmpSum += array.get(x0 + i).get(y0 + size - 1 -i);
        }
        return standard == tmpSum;
    }

}
