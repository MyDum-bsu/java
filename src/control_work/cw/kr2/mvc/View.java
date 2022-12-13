package control_work.cw.kr2.mvc;

import control_work.cw.kr2.iterator.Iterator;
import control_work.cw.kr2.strategy.IteratorStrategy;
import control_work.cw.kr2.strategy.Strategy;
import control_work.cw.kr2.strategy.VisitorStrategy;

import javax.swing.*;
import java.awt.*;

public class View {
    private final Set model;
    private final DefaultListModel<Integer> listModel;
    private JLabel cardinalityLabel;
    private JLabel invertedSetLabel;
    private Strategy iteratorStrategy;
    private Strategy visitorStrategy;

    public View(Set model) {
        this.model = model;
        listModel = new DefaultListModel<>();
        initStrategy();
        initSizeLabel();
        initInvertedSetLabel();
    }

    private void initInvertedSetLabel() {
        invertedSetLabel = new JLabel();
        invertedSetLabel.setForeground(Color.ORANGE);
        invertedSetLabel.setFont(new Font("Courier", Font.PLAIN, 30));
    }

    private void initStrategy() {
        iteratorStrategy = new IteratorStrategy();
        visitorStrategy = new VisitorStrategy();
    }

    private void initSizeLabel() {
        cardinalityLabel = new JLabel("cardinality: iterator - " + iteratorStrategy.cardinality(model) + " visitor - " + visitorStrategy.cardinality(model));
        cardinalityLabel.setForeground(Color.ORANGE);
        cardinalityLabel.setFont(new Font("Courier", Font.PLAIN, 30));
    }

    public void repaint() {
        listModel.clear();
        Iterator iterator = model.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
            listModel.addElement(iterator.currentItem());
            iterator.next();
        }
        cardinalityLabel.setText("cardinality: iterator - " + iteratorStrategy.cardinality(model) + " visitor - " + visitorStrategy.cardinality(model));
        invertedSetLabel.setText(model.toString());
    }

    public DefaultListModel<Integer> getListModel() {
        return listModel;
    }

    public JLabel getCardinalityLabel() {
        return cardinalityLabel;
    }

    public JLabel getInvertedSetLabel() {
        return invertedSetLabel;
    }
}
