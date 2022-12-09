package control_work.template.kr2.strategy;

import control_work.template.kr2.mvc.Stack;
import control_work.template.kr2.visitor.ConcreteVisitor;

public class VisitorStrategy implements Strategy {
    @Override
    public <T> int countSize(Stack<T> element) {
        ConcreteVisitor visitor = new ConcreteVisitor();
        element.accept(visitor);
        return visitor.getCount();
    }
}
