package lab4;

public class Exponential extends Series {
    public Exponential(int n, double firstElement, double d) {
        super(n, firstElement, d);
    }

    @Override
    public double getElement(int j) {
        double element = firstElement;
        while (j > 0) {
            element *= delta;
            j--;
        }
        return element;
    }
}
