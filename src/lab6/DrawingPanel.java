package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private final ArrayList<Line> lines = new ArrayList<>();
    private final ArrayList<Line> bufferLines = new ArrayList<>();
    private Color color;



    public void setColor(Color color) {
        this.color = color;
    }

    public DrawingPanel(Color color) {
        this.color = color;
        setBackground(Color.BLACK);
        DrawingPanelMouseHandler handler = new DrawingPanelMouseHandler();
        addMouseMotionListener(handler);
        addMouseListener(handler);

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(color);
        for (Line line : lines) {
            line.drawLine(graphics);
        }
    }

    @Override
    public void update(Graphics graphics) {
        graphics.setColor(color);
        for (Line bufferLine : bufferLines) {
            bufferLine.drawLine(graphics);
        }
        bufferLines.clear();
    }

    private static class Line {
        private final Point a;
        private final Point b;

        private final Color color;

        private void drawLine(Graphics g) {
            g.setColor(color);
            g.drawLine(a.x, a.y, b.x, b.y);
        }

        Line(Point a, Point b, Color color) {
            this.a = a;
            this.b = b;
            this.color = color;
        }
    }

    private class DrawingPanelMouseHandler extends MouseAdapter implements MouseMotionListener {
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
            Line line = new Line(lastPoint, point, color);
            lines.add(line);
            bufferLines.add(line);
            update(getGraphics());
        }
    }
}