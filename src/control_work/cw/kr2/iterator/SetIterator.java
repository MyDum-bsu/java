package control_work.cw.kr2.iterator;

import control_work.cw.kr2.mvc.Set;

public class SetIterator implements Iterator {
    private final Set collection;
    int current;

    public SetIterator(Set collection) {
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
        return current >= collection.cardinality();
    }

    @Override
    public int currentItem() {
        return collection.get(current);
    }
}
