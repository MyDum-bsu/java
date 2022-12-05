package control_work.template.kr1.first;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person implements Comparable<Person> {
    private String name;
    private int course;
    private double averageScore;

    public Person(String name, int course, double averageScore) {
        this.name = name;
        this.course = course;
        this.averageScore = averageScore;
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(averageScore, o.averageScore);
    }

    public static Person fromString(String s) throws InputMismatchException {
        Scanner scanner = new Scanner(s);
        Person p = new Person("", 0, 0);
        if (!scanner.hasNext("\\w+")) {
            throw new InputMismatchException("Wrong person format");
        }
        p.name = scanner.next();
        if (!scanner.hasNextInt()) {
            throw new InputMismatchException("Wrong person format");
        }
        p.course = scanner.nextInt();
        if (!scanner.hasNextDouble()) {
            throw new InputMismatchException("Wrong person format");
        }
        p.averageScore = scanner.nextDouble();
        return p;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", averageScore=" + averageScore +
                '}';
    }
}