package lab1;

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
        Scanner scanner = new Scanner(System.in);
        java.lang.System.err.print("Enter number, |number| <= 1:");
        double x = scanner.nextDouble();
        java.lang.System.err.print("Enter accuracy:");
        double accuracy = scanner.nextDouble();
        Series series = new Series(x, accuracy);
        java.lang.System.err.println(series.calculateSeries());
    }

}
