package control_work.cw.kr2.strategy;

import control_work.cw.kr2.iterator.Iterator;
import control_work.cw.kr2.mvc.Set;

public class IteratorStrategy implements Strategy {

    @Override
    public int cardinality(Set element) {
        int count = 0;
        Iterator iterator = element.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
            if (iterator.currentItem() == 1) {
                count++;
            }
            iterator.next();
        }
        return count;
    }
}
