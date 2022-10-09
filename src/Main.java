import lab3.BinarySearchTree;
import lab3.Student;
import lab4.Exponential;
import lab4.Liner;
import lab4.Series;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //runIntegerTree();
        //runStudentTree();
        runLab4();
    }

    public static void runIntegerTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(14);
        tree.insert(13);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        System.out.println("preorder walk");
        tree.preorderTreeWalk();
        System.out.println("is 10 in tree: " + tree.search(10));
        System.out.println("\ndelete 10\n");
        tree.delete(10);
        tree.preorderTreeWalk();
        System.out.println("is 10 in tree: " + tree.search(10));

        System.out.println("\ndelete 7\n");
        tree.delete(7);
        tree.preorderTreeWalk();
        System.out.println("is 7 in tree: " + tree.search(7));
    }

    public static void runStudentTree() {
        Student a = new Student(80, "SVY");
        BinarySearchTree<Student> studentTree = new BinarySearchTree<>();
        try {
            studentTree.insert(a);
            studentTree.insert(new Student(228, "MDI"));
            studentTree.insert(new Student(2, "GAA"));
            studentTree.insert(new Student(69, "AYS"));
//            Student ns = null;
//            studentTree.insert(ns);
            studentTree.insert(new Student(4, "RRY"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        }
        studentTree.preorderTreeWalk();
        System.out.println("delete SVY");
        studentTree.delete(a);
        studentTree.preorderTreeWalk();

    }

    private static void runLab4() {
        Series series;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write number of elements, first element and delta:");
        int n = scanner.nextInt();
        double firstElement = scanner.nextDouble();
        double delta = scanner.nextDouble();
        System.out.println("Choose progression: Arithmetic or Geometric");
        System.out.println("Type A or G:");
        String choice = scanner.next();
        try {
            series = setProgression(choice, n, firstElement, delta);
            series.saveToFile(Paths.get("src/lab4/test.txt"));
            System.out.println(series.getSum());
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private static Series setProgression(String choice, int n, double firstElement, double delta) throws IllegalArgumentException {
        if (Objects.equals(choice, "A")) {
            return new Liner(n, firstElement, delta);
        }
        if (Objects.equals(choice, "G")) {
            return new Exponential(n, firstElement, delta);
        }
        throw new IllegalArgumentException("wrong input");
    }
}
