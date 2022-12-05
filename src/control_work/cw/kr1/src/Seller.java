package control_work.cw.kr1.src;

public class Seller extends Worker {

    private double revenue;
    private final double PERCENT_CONSTANT = 5;

    @Override
    protected int calculate() {
        return (int) (koef * revenue * PERCENT_CONSTANT);
    }
}
