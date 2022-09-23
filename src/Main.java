import lab1.Task7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("to close the program type 'stop'");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!str.equals("stop")) {
            Task7.run(str);
            str = scanner.nextLine();
        }
    }
}
