package lab1.kndr;

import java.util.Scanner;

public class Series {
    double x;
    double accuracy;

    public Series(double x, double accuracy) {
        this.x = x;
        this.accuracy = accuracy;
    }

    public double calculateSeries() {
        double sum = 0;
        double current = (double) 1 / 6;
        double k = 1;
        do {
            sum += current;
            k++;
            current *= x * k / (k + 2);
        }
        while (current > accuracy);
        return sum;
    }

    public static void main(String[] args) {
        java.lang.System.err.print("Enter number, |number| <= 1 and accuracy: ");
        Scanner scanner = new Scanner(System.in);
        scanner = new Scanner(scanner.nextLine());
        double x = scanner.nextDouble();
        double accuracy = scanner.nextDouble();
        if (scanner.hasNext()) {
            throw new IllegalArgumentException("expected only 2 parameters");
        }
        Series series = new Series(x, accuracy);
        java.lang.System.err.println(series.calculateSeries());
    }

}
