package control_work.template.kr2.iterator;

import control_work.template.kr2.mvc.Stack;

public class CollectionIterator<T> implements Iterator<T> {
    private final Stack<T> collection;
    int current;

    public CollectionIterator(Stack<T> collection) {
        this.collection = collection;
        current = 0;
    }

    @Override
    public void first() {
        current = 0;
    }

    @Override
    public void next() {
        current++;
    }

    @Override
    public boolean isDone() {
        return current >= collection.size();
    }

    @Override
    public T currentItem() {
        return collection.get(current);
    }
}
