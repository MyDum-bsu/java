package lab9;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Set<T> implements Iterator<T> {

    private final ArrayList<T> data;

    public Set() {
        data = new ArrayList<>();
    }
    public Set(Set<T> s) {
        this.data = s.data;
    }

    @Override
    public boolean hasNext() {
        return data.iterator().hasNext();
    }

    @Override
    public T next() {
        return data.iterator().next();
    }

    public int size() {
        return data.size();

    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void clear() {
        data.clear();
    }

    public void add(T element) {
        data.add(element);
    }

    public void remove(Object o) {
        data.remove(o);
    }

    public void addAll(Collection<T> collection) {
        data.addAll(collection);
    }

    public Set<T> union(Set<T> s) {
        Set<T> unionSet = new Set<>(this);
        while(s.hasNext()) {
            T element = s.next();
            if (!unionSet.data.contains(element)) {
                unionSet.add(element);
            }
        }
        return unionSet;
    }

    public Set<T> intersection(Set<T> s) {
        Set<T> intersectionSet = new Set<>();
        while(s.hasNext()) {
            T element = s.next();
            if (this.data.contains(element)) {
                intersectionSet.add(element);
            }
        }
        return intersectionSet;
    }

    public Set<T> difference(Set<T> set) {
        Set<T> differenceSet = new Set<>();
        while (this.hasNext()) {
            T element = this.next();
            if (!set.data.contains(element)) {
                differenceSet.add(element);
            }
        }
        return differenceSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set<?> set = (Set<?>) o;
        return Objects.equals(data, set.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Set{" +
                "data=" + data +
                '}';
    }

    public DefaultListModel<T> getListModel() {
        DefaultListModel<T> model = new DefaultListModel<>();
        for (T element : data) {
            model.addElement(element);
        }
        return model;
    }
}
