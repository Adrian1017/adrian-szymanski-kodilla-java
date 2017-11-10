package com.kodilla.testing.shape;

public class Square implements Shape{
    private int width;

    public Square(int width){
    this.width = width;
    }
    @Override
    public String getShapeName() {
        return this.getClass().toString();
    }

    @Override
    public double getField() {
        return width *width;
    }
}
