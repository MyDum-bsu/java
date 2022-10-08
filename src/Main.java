import lab3.BinarySearchTree;
import lab3.Student;
import lab4.Exponential;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        //runIntegerTree();
        runStudentTree();
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
        System.out.println("is 10 in tree: "+ tree.search(10));
        System.out.println("\ndelete 10\n");
        tree.delete(10);
        tree.preorderTreeWalk();
        System.out.println("is 10 in tree: "+ tree.search(10));

        System.out.println("\ndelete 7\n");
        tree.delete(7);
        tree.preorderTreeWalk();
        System.out.println("is 7 in tree: "+ tree.search(7));
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

    public static void runLab4() {
        Exponential seria = new Exponential(10, 1, 3);
        try {
            seria.saveToFile(Paths.get("src/lab4/test.txt"));
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}