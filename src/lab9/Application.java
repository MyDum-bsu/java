package lab9;

public class Application {
    public static void main(String[] args) {
        Set<Integer> set = Set.create();
        Set<Integer> newSet = Set.create();
        for (int i = 0 ; i < 10; i++) {
            set.add(i);
            newSet.add(9 - i);
        }
        System.out.println(set.equals(newSet));
        Set<Integer> copy = Set.copy(newSet);
        System.out.println(copy.equals(set));
    }
}
