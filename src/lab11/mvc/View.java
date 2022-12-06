package lab11.mvc;


import lab11.iterator.Iterator;

import javax.swing.*;

public class View<T> {
    private final DefaultListModel<T> listModel;
    private final Set<T> model;

    public DefaultListModel<T> getListModel() {
        return listModel;
    }
    public View(Set<T> model) {
        this.model = model;
        listModel = new DefaultListModel<>();
    }

    public void repaint() {
        listModel.clear();
        Iterator<T> iterator = model.createIterator();
        iterator.first();
        while(!iterator.isDone()) {
            listModel.addElement(iterator.currentItem());
            iterator.next();
        }
    }
}
