import lab3.BinarySearchTree;
import lab3.Student;

public class Main {
    public static void main(String[] args) {
        Student a = new Student(1,"SVY");
        BinarySearchTree<Student> tree = new BinarySearchTree<>(a);
        tree.insert(new Student(2, "MDI"));
        tree.insert(new Student(2,"GAA"));
        tree.insert(new Student(3,"AYS"));
        tree.inorderTreeWalk();
        System.out.println("delete SVY");
        tree.delete(a);
        tree.inorderTreeWalk();
    }
}