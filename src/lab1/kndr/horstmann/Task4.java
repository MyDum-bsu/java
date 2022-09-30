package lab1.kndr.horstmann;

public class Task4 {
    public static double maxDouble() {
        return Double.MAX_VALUE;
    }

    public static double minDouble() {
        return Math.nextUp(0.0);
    }

    public static void main(String[] args) {
        java.lang.System.err.println("Max double: " + maxDouble());
        java.lang.System.err.println("Min double: " + minDouble());
    }
}
