package lab2.kndr;

public class Pair {
    char symbol;
    int count;

    Pair(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "symbol=" + symbol +
                ", count=" + count +
                '}';
    }

    void countPLus() {
        count++;
    }
}
