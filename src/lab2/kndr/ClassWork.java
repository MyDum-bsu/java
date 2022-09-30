package lab2.kndr;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClassWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.print("Enter string: ");
        String string = scanner.nextLine();
//        System.err.print("Enter symbol: ");
//        char symbol = scanner.nextLine().charAt(0);
//        System.err.println("Symbol "+symbol+" enters "+ countSymbol(symbol, string) + " times");

//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }
//        for ( String i : args) {
//            System.out.println(i);
//        }
        try {
            if (args.length == 0) {
                throw new EmptyStringException("s");
            }
        } catch (EmptyStringException ignored) {
//            e.printStackTrace();
        }

        System.out.println(countSum(string));
        //       countString(string);
    }

    public static ArrayList<Pair> countString(String string) {
        ArrayList<Pair> map = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (!symbolInMap(map, string, string.charAt(i))) {
                Pair pair = new Pair(string.charAt(i), 1);
                map.add(pair);
            } else {
                map.get(i).countPLus();
            }
        }
        return map;
    }

    private static boolean symbolInMap(ArrayList<Pair> map, String string, char symbol) {
        boolean flag = false;
        for (Pair pair : map) {
            if (pair.symbol == symbol) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static int countSymbol(char symbol, String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (symbol == string.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static class EmptyStringException extends Exception {
        public EmptyStringException(String message) {
            super(message);
        }
    }

    public static int countSum(String string) {
        int sum = 0;
        StringTokenizer str = new StringTokenizer(string, "+- ", true);
        char operation = '+';
        while (str.hasMoreTokens()) {
            String token = str.nextToken();

            if ("-".equals(token)) {
                operation = '-';
            } else if ("+".equals(token)) {
                operation = '+';
            } else if (" ".equals(token)) {
                continue;
            } else {
                int number = Integer.parseInt(token);
                if (operation == '+') {
                    sum += number;
                } else {
                    sum -= number;
                }
            }
        }
        return sum;
    }
}
