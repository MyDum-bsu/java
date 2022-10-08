package lab4;

public class Liner extends Series {
    public Liner(int n, int firstElement, int d) {
        super(n, firstElement, d);
    }

    @Override
    public double getElement(int j) {
        if (j == 0) {
            return firstElement;
        }
        return firstElement + j * delta;
    }
}
