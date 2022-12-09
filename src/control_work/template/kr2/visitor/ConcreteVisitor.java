package control_work.template.kr2.visitor;

import control_work.template.kr2.mvc.Stack;
import control_work.template.kr2.iterator.Iterator;

public class ConcreteVisitor implements Visitor {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public <T> void visitMyCollection(Stack<T> e) {
        Iterator<T> iterator = e.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
            iterator.next();
            count++;
        }
    }
}
