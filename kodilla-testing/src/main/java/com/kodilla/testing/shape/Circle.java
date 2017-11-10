package com.kodilla.testing.shape;

public class Circle implements Shape{
    private final double PI = 3.14159;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public String getShapeName() {
        return null;
    }
    @Override
    public double getField() {
        return  PI * radius * radius;
    }
}
