package control_work.template.kr2.strategy;

import control_work.template.kr2.mvc.Stack;
import control_work.template.kr2.iterator.Iterator;

public class IteratorStrategy implements Strategy {

    @Override
    public <T> int countSize(Stack<T> element) {
        Iterator<T> iterator = element.createIterator();
        iterator.first();
        int size = 0;
        while (!iterator.isDone()) {
            iterator.next();
            size++;
        }
        return size;
    }
}
