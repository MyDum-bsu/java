package control_work.template.kr2.mvc;

public class Controller<T> {
    private final Stack<T> model;
    private final View<T> view;
    public Controller(Stack<T> model, View<T> view) {
        this.model = model;
        this.view = view;
    }

    public void push(T element) {
        model.push(element);
        view.repaint();
    }
    public T pop() {
        T element = model.pop();
        view.repaint();
        return element;
    }
}
