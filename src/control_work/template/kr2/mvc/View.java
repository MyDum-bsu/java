package control_work.template.kr2.mvc;

import control_work.template.kr2.iterator.Iterator;
import control_work.template.kr2.strategy.IteratorStrategy;
import control_work.template.kr2.strategy.Strategy;
import control_work.template.kr2.strategy.VisitorStrategy;

import javax.swing.*;
import java.awt.*;

public class View<T> {
    private final Stack<T> model;
    private final DefaultListModel<T> listModel;
    private JLabel poppedText;
    private JLabel sizeLabel;
    private Strategy iteratorStrategy;
    private Strategy visitorStrategy;

    public View(Stack<T> model) {
        this.model = model;
        listModel = new DefaultListModel<>();
        initStrategy();
        initPoppedText();
        initSizeLabel();
    }

    private void initStrategy() {
        iteratorStrategy = new IteratorStrategy();
        visitorStrategy = new VisitorStrategy();
    }

    private void initSizeLabel() {
        sizeLabel = new JLabel("size: iterator - " + iteratorStrategy.countSize(model) + " visitor - " + visitorStrategy.countSize(model));
        sizeLabel.setForeground(Color.ORANGE);
        sizeLabel.setFont(new Font("Courier", Font.PLAIN, 30));
    }

    private void initPoppedText() {
        poppedText = new JLabel();
        poppedText.setBackground(Color.BLACK);
        poppedText.setForeground(Color.GREEN);
        poppedText.setFont(new Font("Courier", Font.PLAIN, 45));
    }

    public void repaint() {
        listModel.clear();
        Iterator<T> iterator = model.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
            listModel.addElement(iterator.currentItem());
            iterator.next();
        }
        sizeLabel.setText("size: iterator - " + iteratorStrategy.countSize(model) + " visitor - " + visitorStrategy.countSize(model));
    }

    public DefaultListModel<T> getListModel() {
        return listModel;
    }

    public JLabel getPoppedTextLabel() {
        return poppedText;
    }

    public JLabel getSizeLabel() {
        return sizeLabel;
    }

    public void setPoppedText(String text) {
        poppedText.setText(text);
    }
}
