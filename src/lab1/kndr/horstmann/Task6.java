package lab1.kndr.horstmann;

import java.math.BigInteger;
import java.util.Scanner;

public class Task6 {
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.lang.System.err.print("Enter number: ");
        int number = scanner.nextInt();
        java.lang.System.err.print(number+"! = ");
        java.lang.System.err.println(factorial(number));
    }
}
