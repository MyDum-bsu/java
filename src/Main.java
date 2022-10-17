import lab4.Exponential;
import lab4.Liner;
import lab4.Series;
import lab4.SeriesApplication;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new SeriesApplication(400,400);
    }

    private static void runSeries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write number of elements, first element and delta:");
        try {
            int n = scanner.nextInt();
            double firstElement = scanner.nextDouble();
            double delta = scanner.nextDouble();
            System.out.println("Choose progression: Linear or Exponential");
            System.out.println("Type L or E:");
            String choice = scanner.next();

            Series series;

            series = setProgression(choice, n, firstElement, delta);
            series.saveToFile(Paths.get("src/lab4/test.txt"));
            System.out.println(series.getSum());
        } catch ( IllegalArgumentException | IOException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (InputMismatchException e) {
            System.err.println("wrong number");
            System.exit(2);
        }
    }

    private static Series setProgression(String choice, int n, double firstElement, double delta) throws IllegalArgumentException {
        if (choice.equalsIgnoreCase("L")) {
            return new Liner(n, firstElement, delta);
        }
        if (choice.equalsIgnoreCase("E")) {
            return new Exponential(n, firstElement, delta);
        }
        throw new IllegalArgumentException("wrong input");
    }
}
