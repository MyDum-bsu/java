package lab4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Series {
    protected final int n;
    protected double firstElement;
    protected double delta;

    Series(int n, double firstElement, double d) {
        this.n = n;
        this.firstElement = firstElement;
        this.delta = d;
    }

    public abstract double getElement(int j);

    public double getSum() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += getElement(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < n; i++) {
            string.append(getElement(i)).append(" ");
        }
        return string.toString();
    }

    public void saveToFile(Path path) throws IOException {
        for (int i = 0; i < n; i++) {
            Files.write(path, toString().getBytes());
        }
    }
}
