import lab1.Task7;
import lab2.Matrix;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("to close the program type 'stop'");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!str.equals("stop")) {
            Task7.run(str);
            str = scanner.nextLine();
        }
    }
}
