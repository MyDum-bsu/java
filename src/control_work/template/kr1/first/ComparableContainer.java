package control_work.template.kr1.first;

import java.util.*;
import java.util.function.Consumer;

public class ComparableContainer<T extends Comparable<T>> implements Iterable<T> {
    private static final String EXCEPTION_MESSAGE = "The data is empty!";
    private final List<T> data;


    public ComparableContainer(List<T> data) {
        this.data = data;
    }
    public ComparableContainer() {
        this.data = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    T max() throws EmptyCollectionException {
        if (data.isEmpty())
            throw new EmptyCollectionException(EXCEPTION_MESSAGE);
        return data.stream().max(Comparator.naturalOrder()).get();
    }
    T min() throws EmptyCollectionException {
        if (data.isEmpty())
            throw new EmptyCollectionException(EXCEPTION_MESSAGE);
        return data.stream().min(Comparator.naturalOrder()).get();
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        data.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return data.spliterator();
    }
}
