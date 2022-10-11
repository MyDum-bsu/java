import lab4.Application;
import lab4.Exponential;
import lab4.Liner;
import lab4.Series;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Application app = new Application(300, 300);
        //runLab4();

    }

    private static void runLab4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write number of elements, first element and delta:");
        int n = scanner.nextInt();
        double firstElement = scanner.nextDouble();
        double delta = scanner.nextDouble();
        System.out.println("Choose progression: Arithmetic or Geometric");
        System.out.println("Type A or G:");
        String choice = scanner.next();
        Series series;
        try {
            series = setProgression(choice, n, firstElement, delta);
            series.saveToFile(Paths.get("src/lab4/test.txt"));
            System.out.println(series.getSum());
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private static Series setProgression(String choice, int n, double firstElement, double delta) throws IllegalArgumentException {
        if (Objects.equals(choice, "A")) {
            return new Liner(n, firstElement, delta);
        }
        if (Objects.equals(choice, "G")) {
            return new Exponential(n, firstElement, delta);
        }
        throw new IllegalArgumentException("wrong input");
    }
}
