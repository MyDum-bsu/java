package lab1.kndr.horstmann;

public class Task5 {

    public static void main(String[] args) {
        double testNum = 1075875987458745793457.2;
        System.err.println("Number before casting: " + testNum);
        System.err.println("Number after casting: " + (int) testNum);
        System.err.println("Max int: " + Integer.MAX_VALUE);
        // SO, IN THAT CASE NUMBER BECOMES INTEGER.MAX_VALUE
    }
}
