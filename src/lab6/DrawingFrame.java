package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DrawingFrame extends JFrame {

    private final ArrayList<Line> lines = new ArrayList<>();
    private final ArrayList<Line> bufferLines = new ArrayList<>();
    private Color color = Color.RED;

    JRadioButton redButton;
    JRadioButton greenButton;
    JRadioButton blueButton;

    public DrawingFrame() {
        super("Drawing Frame");
        initDefaultSet();
        DrawingFrameMouseHandler handler = new DrawingFrameMouseHandler();
        addMouseMotionListener(handler);
        addMouseListener(handler);
        initColorButtons();
        setVisible(true);
    }

    private void initDefaultSet() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 300, dimension.height / 2 - 150, 600, 300);
        setMinimumSize(new Dimension(600, 300));
        getContentPane().setBackground(Color.BLACK);
    }

    private void initColorButtons() {
        ButtonGroup buttonGroup = new ButtonGroup();
        redButton = new JRadioButton("red");
        greenButton = new JRadioButton("green");
        blueButton = new JRadioButton("blue");
        JPanel colorPanel = new JPanel(new FlowLayout());
        colorPanel.setBackground(Color.BLACK);
        buttonGroup.add(redButton);
        redButton.setSelected(true);
        buttonGroup.add(greenButton);
        buttonGroup.add(blueButton);

        colorPanel.add(redButton);
        colorPanel.add(greenButton);
        colorPanel.add(blueButton);
        add(colorPanel);
    }

    private Color getColor() {
        if (redButton.isSelected()) {
            return Color.RED;
        } else if (greenButton.isSelected()) {
            return Color.GREEN;
        }
        return Color.BLUE;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        color = getColor();
        graphics.setColor(color);
        for (Line line : lines) {
            line.drawLine(graphics);
        }
    }

    @Override
    public void update(Graphics graphics) {
        color = getColor();
        graphics.setColor(color);
        for (Line bufferLine : bufferLines) {
            bufferLine.drawLine(graphics);
        }
        bufferLines.clear();
    }

    private static class Line {
        private final Point a;
        private final Point b;

        private void drawLine(Graphics g) {
            g.drawLine(a.x, a.y, b.x, b.y);
        }

        Line(Point a, Point b) {
            this.a = a;
            this.b = b;
        }
    }

    private class DrawingFrameMouseHandler extends MouseAdapter implements MouseMotionListener {
        private Point lastPoint;

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            addLine(mouseEvent.getPoint());
            lastPoint = mouseEvent.getPoint();
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            lastPoint = mouseEvent.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            lastPoint = null;
        }

        private void addLine(Point point) {
            Line line = new Line(lastPoint, point);
            lines.add(line);
            bufferLines.add(line);
            update(getGraphics());
        }
    }
}