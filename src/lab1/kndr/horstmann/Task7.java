package lab1.kndr.horstmann;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.lang.System.err.print("Enter first number, -1 < number < 65536: ");
        short first = scanner.nextShort();
        java.lang.System.err.print("Enter second number, -1 < number < 65536: ");
        short second = scanner.nextShort();
        java.lang.System.err.println(first + " + " + second + " = " + (first+second));
        java.lang.System.err.println(first + " - " + second + " = " + (first-second));
        java.lang.System.err.println(first + " * " + second + " = " + (first*second));
        java.lang.System.err.println(first + " / " + second + " = " + (first/second));
        java.lang.System.err.println(first + " % " + second + " = " + (first%second));

    }
}
