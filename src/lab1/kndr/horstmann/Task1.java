package lab1.kndr.horstmann;

import java.util.Scanner;

public class Task1 {

    public static String decimalToBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public static String decimalToHex(int number) {
        return Integer.toHexString(number);
    }

    public static String decimalToOct(int number) {
        return Integer.toOctalString(number);
    }

    public static String oppositeNumberInHexForm(int number) {
        return Double.toHexString((1 / (double) number));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.lang.System.err.print("Enter number:");
        int x = scanner.nextInt();
        java.lang.System.err.println("in binary form: " + decimalToBinary(x));
        java.lang.System.err.println("in hexadecimal form: " + decimalToHex(x));
        java.lang.System.err.println("in octal form: " + decimalToOct(x));
        java.lang.System.err.println("in reverse form: " + oppositeNumberInHexForm(x));
    }
}
