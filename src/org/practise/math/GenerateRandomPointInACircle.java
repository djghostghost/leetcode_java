package org.practise.math;


import java.util.Random;

//https://leetcode.com/problems/generate-random-point-in-a-circle/description/
class Solution {

    private double radius;
    private double xCenter;
    private double yCenter;
    private Random random;

    private double xMin;
    private double yMin;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        xCenter = x_center;
        yCenter = y_center;
        xMin = xCenter - radius;
        yMin = yCenter - radius;
        random = new Random();
    }

    public double[] randPoint() {

        double x, y;
        do {
            x = xMin + random.nextDouble() * (2 * radius);
            y = yMin + random.nextDouble() * (2 * radius);


        } while (!inCircle(x, y));


        return new double[]{x, y};
    }

    private boolean inCircle(double x, double y) {
        double x1 = x - xCenter;
        double y1 = y - yCenter;

        return x1 * x1 + y1 * y1 <= radius * radius;
    }
}

