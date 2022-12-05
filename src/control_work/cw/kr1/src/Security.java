package control_work.cw.kr1.src;

public class Security extends Worker {

    private double square;
    private final double BASE_CONSTANT = 10;

    @Override
    protected int calculate() {
        return (int) (BASE_CONSTANT * koef * square);
    }

}
