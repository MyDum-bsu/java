package control_work.template.kr1.tree;

public abstract class Tree implements Comparable<Tree> {
    public Tree() {
        this.name = "none";
        this.type = "none";
        this.old = 0;
    }

    public Tree(String name, String type, int old) {
        this.name = name;
        this.type = type;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    private String name;
    private String type;
    private int old;

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", old=" + old +
                '}';
    }

    @Override
    public int compareTo(Tree o) {
        if (!name.equals(o.name))
            return name.compareTo(o.name);
        if (!(o.old - old == 0)) {
            return o.old - old;
        }
        return type.compareTo(o.type);
    }

    @Override
    public boolean equals(Object o) {
        Tree temp = (Tree) o;
        return this.name.equals(temp.name) && this.old == temp.old && this.type.equals(temp.type);
    }
}
