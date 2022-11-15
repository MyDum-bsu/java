package lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExportDialog extends JDialog implements ActionListener {
    private final JButton acceptButton;
    private JLabel nameLabel;
    private JLabel countryLabel;
    private JLabel quantityLabel;
    private JTextField nameText;
    private JTextField countryText;
    private JTextField quantityText;
    Export export;

    AddExportDialog(JFrame frame) {
        super(frame, "add export", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        export = new Export();
        acceptButton = new JButton("ok");
        initLabels();
        initTextFields();
        acceptButton.addActionListener(this);
        initForm();
        setVisible(true);
    }

    private void initForm() {
        setLayout(new GridLayout(4, 2));
        add(nameLabel);
        add(nameText);
        add(countryLabel);
        add(countryText);
        add(quantityLabel);
        add(quantityText);
        add(new JLabel());
        add(acceptButton);
        pack();
    }

    private void initTextFields() {
        nameText = new JTextField("", 5);
        countryText = new JTextField("", 5);
        quantityText = new JTextField("", 5);
    }

    private void initData() {
        export.setName(nameText.getText());
        export.setCountry(countryText.getText());
        export.setQuantity(Integer.parseInt(quantityText.getText()));
    }

    private void initLabels() {
        nameLabel = new JLabel("name");
        countryLabel = new JLabel("country");
        quantityLabel = new JLabel("quantity");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(acceptButton)) {
            initData();
            // TODO: add exceptions
        }
    }
}
