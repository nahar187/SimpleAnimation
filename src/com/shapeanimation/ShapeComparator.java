package com.shapeanimation;

import java.util.Comparator;

/**
 * Shape sort by z-axis in descending order.
 */
public class ShapeComparator implements
        Comparator<Shape> {

    @Override
    public int compare(Shape shape1, Shape shape2) {
        Double z1 = shape1.getZ();
        Double z2 = shape2.getZ();
        return z1 < z2 ? 1 : (z1 == z2 ? 0 : -1);
    }

}
