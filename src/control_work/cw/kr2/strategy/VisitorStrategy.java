package control_work.cw.kr2.strategy;

import control_work.cw.kr2.mvc.Set;
import control_work.cw.kr2.visitor.SetVisitor;

public class VisitorStrategy implements Strategy {
    @Override
    public int cardinality(Set element) {
        SetVisitor visitor = new SetVisitor();
        element.accept(visitor);
        return visitor.getCount();
    }
}
