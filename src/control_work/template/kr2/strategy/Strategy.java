package control_work.template.kr2.strategy;

import control_work.template.kr2.mvc.Stack;

public interface Strategy {
    <T> int countSize(Stack<T> element);
}
