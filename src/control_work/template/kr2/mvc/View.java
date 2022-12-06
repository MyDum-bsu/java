package control_work.template.kr2.mvc;

import control_work.template.kr2.iterator.Iterator;

import javax.swing.*;

public class View<T> {
    private final DefaultListModel<T> listModel;
    private final Stack<T> model;

    public DefaultListModel<T> getListModel() {
        return listModel;
    }
    public View(Stack<T> model) {
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