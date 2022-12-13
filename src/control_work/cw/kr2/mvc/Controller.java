package control_work.cw.kr2.mvc;

import java.io.File;
import java.io.IOException;

public class Controller {
    private final Set model;
    private final View view;

    public Controller(Set model, View view) {
        this.model = model;
        this.view = view;
    }

    public void add(int element) throws IllegalArgumentException {
        model.add(element);
        view.repaint();
    }

    public void save(File file) throws IOException {
        model.save(file);
    }
}
