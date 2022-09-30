package lab1.kndr.horstmann;

import java.util.Scanner;

public class Task2 {

    public static int normalizeAngle(int angle) {
        if (angle > 0) {
            angle %= 360;
        } else {
            while (angle < 0) {
                angle += 360;
            }
        }
        return angle;
    }

    public static int normalizeAngleWithFloorMod(int angle) {
        return Math.floorMod(angle, 360);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.lang.System.err.print("Enter angle:");
        int angle = scanner.nextInt();
        java.lang.System.err.println("Normalised angle:");
        java.lang.System.err.println(normalizeAngle(angle));
        java.lang.System.err.println(normalizeAngleWithFloorMod(angle));
    }

}
