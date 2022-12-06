package control_work.template.kr2.iterator;

public interface Iterator<T> {
    void first();

    void next();

    boolean isDone();

    T currentItem();
}
