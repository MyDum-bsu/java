package lab11.visitor;

import lab11.iterator.Iterator;
import lab11.mvc.Set;

public class IsEmptyVisitor implements Visitor {
    private boolean isEmpty;
    public IsEmptyVisitor() {
        isEmpty = false;
    }
    @Override
    public <T> void visit(Set<T> e) {
        Iterator<T> iterator = e.createIterator();
        iterator.first();
        isEmpty = iterator.isDone();
    }
    public boolean isEmpty() {
        return isEmpty;
    }
}
