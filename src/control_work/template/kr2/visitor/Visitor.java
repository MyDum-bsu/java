package control_work.template.kr2.visitor;

import control_work.template.kr2.mvc.Stack;

public interface Visitor {
    <T> void visitMyCollection(Stack<T> e);
}
