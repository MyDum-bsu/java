package lab11.mvc;

import lab11.iterator.Iterator;

import javax.swing.*;

public class View<T> {

    public DefaultListModel<T> getListModel() {
        return listModel;
    }

    private final DefaultListModel<T> listModel;
    private final Set<T> model;

    public View(Set<T> model) {
        listModel = new DefaultListModel<>();
        this.model = model;
        repaintList();
    }

    public void repaintList() {
        listModel.clear();
        Iterator<T> iterator = model.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
            listModel.addElement(iterator.currentItem());
            iterator.next();
        }
    }
}
