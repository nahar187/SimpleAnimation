package com.shapeanimation;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    private double x;
    private double y;
    private double z;
    private double radius;
    private Color color = null;

    protected Shape(double x, double y, double z, double radius,
            Color color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.color = color;
    }

    public abstract void draw(Graphics g);
    public void move(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getRadius() {
        return this.radius;
    }

    public Color getColor() {
        return this.color;
    }

    protected void setX(double x) {
        this.x = x;
    }

    protected void setY(double y) {
        this.y = y;
    }

    protected void setZ(double z) {
        this.z = z;
    }

}
