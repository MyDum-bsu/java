package control_work.template.kr1.tree;

public class FruitTree extends Tree {
    public FruitTree() {
        super();
    }

    public FruitTree(String name, int old, String type, int mass, int average) {
        super(name, type, old);
        this.mass = mass;
        this.average = average;
    }

    private int mass;
    private int average;

    @Override
    public String toString() {
        return super.toString() + '\t' + mass + '\t' + mass + "] ";
    }

    @Override
    public boolean equals(Object o) {
        FruitTree temp = (FruitTree) o;
        return super.equals(o) && mass == temp.mass && average == temp.average;
    }
}
