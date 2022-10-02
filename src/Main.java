import lab3.BinarySearchTree;
import lab3.Student;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Student> tree = new BinarySearchTree<>(new Student(1,"SVY"));
        tree.insert(new Student(2, "MDI"));
        tree.insert(new Student(2,"GAA"));
        tree.insert(new Student(3,"AYS"));
        tree.inorderTreeWalk();
        System.out.println(tree.maximum());
        System.out.println(tree.minimum());

    }
}