package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private double height;
    private double width;

    public Triangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    @Override
    public String getShapeName() {

        return this.getClass().toString();
    }

    @Override
    public double getField() {
      return  (width* height)/2;
    }
}
