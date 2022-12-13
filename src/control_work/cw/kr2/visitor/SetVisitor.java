package control_work.cw.kr2.visitor;


import control_work.cw.kr2.iterator.Iterator;
import control_work.cw.kr2.mvc.Set;

public class SetVisitor implements Visitor {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void visitSet(Set e) {
        Iterator iterator = e.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
            if (iterator.currentItem() == 1) {
                count++;
            }
            iterator.next();
        }
    }
}
