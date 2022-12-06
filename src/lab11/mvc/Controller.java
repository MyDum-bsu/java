package lab11.mvc;


public class Controller<T> {
    private final Set<T> model;
    private final View<T> view;
    public Controller(Set<T> model, View<T> view) {
        this.model = model;
        this.view = view;
    }

    public void add(T element) {
        model.add(element);
        view.repaint();
    }
    public void remove(T element) {
        model.remove(element);
        view.repaint();
    }
}
