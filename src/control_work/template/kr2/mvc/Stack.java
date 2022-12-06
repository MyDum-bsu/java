package control_work.template.kr2.mvc;

import control_work.template.kr2.iterator.CollectionIterator;
import control_work.template.kr2.iterator.IterableCollection;
import control_work.template.kr2.iterator.Iterator;
import control_work.template.kr2.visitor.Element;
import control_work.template.kr2.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack<T> implements Element, IterableCollection<T> {
    private final List<T> list;

    private Stack() {
        list = new ArrayList<>();
    }

    private Stack(Stack<T> collection) {
        this.list = collection.list;
    }

    public static <T> Stack<T> create() {
        return new Stack<>();
    }

    public static <T> Stack<T> copy(Stack<T> collection) {
        return new Stack<>(collection);
    }

    public int size() {
        return list.size();
    }

    @Override
    public void accept(Visitor v) {
        v.visitMyCollection(this);
    }

    @Override
    public Iterator<T> createIterator() {
        return new CollectionIterator<>(this);
    }

    public T get(int current) {
        return list.get(current);
    }

    public void push(T element) {
        list.add(element);
    }

    public void pushAll(Stack<T> collection) {
        Iterator<T> iterator = collection.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
            push(iterator.currentItem());
            iterator.next();
        }
    }

    public T pop() {
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stack)) return false;

        Stack<?> that = (Stack<?>) o;

        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "list=" + list +
                '}';
    }
}
