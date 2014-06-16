package com.shapeanimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeAnimation extends JPanel {
    private static final long serialVersionUID = 1L;
    private List<Shape> shapeList = null;

    public static void main(String[] args) {
        ShapeAnimation pc = new ShapeAnimation();
        pc.runScenario();
    }

    public ShapeAnimation() {
        JFrame app = new JFrame("Computer Science");
        app.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        app.setSize(Configuration.WIDTH, Configuration.HEIGHT);
        app.setResizable(false);
        app.getContentPane().add(this);
        app.setVisible(true);
        shapeList = new ArrayList<Shape>();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // sort the shapes based on the z-axis descending order.
        Collections.sort(shapeList, new ShapeComparator());
        for (Shape s : shapeList) {
            s.draw(g);
        }
    }

    /**
     * Paint the components with a waiting interval of 100 ms.
     */
    private void pause() {
        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    private void runScenario() {
        Shape oval = new Oval(100, 100, 0, 20, Color.YELLOW);
        Shape diamond1 = new Diamond(-100, -150, 0, 20, Color.BLUE);
        Shape diamond2 = new Diamond(30, 0, 400, 40, Color.RED);
        shapeList.add(oval);
        shapeList.add(diamond1);
        shapeList.add(diamond2);
        pause();
        for (int i = 0; true; i++) {
            double theta = 2.0 * Math.PI * i / 50.0;
            oval.move(300.0 * Math.cos(theta + 1.0), 10, 300.0 * Math.sin(theta + 1.0) + 300);
            diamond1.move(30, 300.0 * Math.cos(theta), 250.0 * Math.sin(theta) + 250);
            pause();
        }
    }

}
