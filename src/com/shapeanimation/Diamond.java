package com.shapeanimation;

import java.awt.Color;
import java.awt.Graphics;

public class Diamond extends Shape {

    public Diamond(double x, double y, double z, double radius, Color color) {
        super(x, y, z, radius, color);
    }

    @Override
    public void draw(Graphics g) {
        final double CENTER = Configuration.SIZE / 2.0;
        double d = CENTER / (this.getZ() + CENTER);
        double r = this.getRadius() * d;
        double x = this.getX() * d - r + CENTER;
        double y = this.getY() * d - r + CENTER;
        g.setColor(this.getColor());
        g.fillRect((int) x, (int) y, (int) r * 2, (int) r * 2);
    }


}
