package lab1.kndr.horstmann;

import java.util.Scanner;

public class Task3 {
    public static int maxOfThree(int first, int second, int third) {
        int answer;
        if (first >= second) {
            answer = Math.max(third, first);
        } else {
            answer = Math.max(third, second);
        }
        return answer;
    }

    public static int maxOfThreeWithMax(int first, int second, int third) {
        return Math.max(Math.max(first, second), Math.max(second, third));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.lang.System.err.print("Enter first number: ");
        int first = scanner.nextInt();
        java.lang.System.err.print("Enter second number: ");
        int second = scanner.nextInt();
        java.lang.System.err.print("Enter third number: ");
        int third = scanner.nextInt();
        java.lang.System.err.print("Max is: ");
        java.lang.System.err.println(maxOfThree(first, second, third));
        java.lang.System.err.print("Max is: ");
        java.lang.System.err.println(maxOfThreeWithMax(first, second, third));

    }
}
