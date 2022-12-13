package control_work.cw.kr2.mvc;

import control_work.cw.kr2.iterator.SetIterator;
import control_work.cw.kr2.iterator.IterableCollection;
import control_work.cw.kr2.iterator.Iterator;
import control_work.cw.kr2.visitor.Element;
import control_work.cw.kr2.visitor.Visitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Set implements Element, IterableCollection {
    private final List<Integer> list;

    private Set() {
        list = new ArrayList<>();
    }

    public static Set create() {
        return new Set();
    }

    public int cardinality() {
        return list.size();
    }

    @Override
    public void accept(Visitor v) {
        v.visitSet(this);
    }

    @Override
    public Iterator createIterator() {
        return new SetIterator(this);
    }

    public int get(int current) {
        return list.get(current);
    }

    public void add(int element) throws IllegalArgumentException {
        if (element == 0 || element == 1) {
            list.add(element);
        } else {
            throw new IllegalArgumentException("only 1 and 0");
        }
    }

    public void save(File file) throws IOException {
        if (file.createNewFile()) {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(invert().toString());
            fileWriter.close();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Set)) return false;

        Set that = (Set) o;

        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    private List<Integer> invert() {
        List<Integer> inverted = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (current != 0) {
                inverted.add(current * i);
            }
        }
        return inverted;
    }

    @Override
    public String toString() {
        return invert().toString();
    }
}
