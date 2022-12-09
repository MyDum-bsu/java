package control_work.template.kr2.mvc;

public class Controller {
    private final Stack<String> model;
    private final View<String> view;

    public Controller(Stack<String> model, View<String> view) {
        this.model = model;
        this.view = view;
    }

    public void push(String element) {
        model.push(element);
        view.repaint();
    }

    public void pop() {
        String element = model.pop();
        view.setPoppedText(element);
        view.repaint();
    }
}
