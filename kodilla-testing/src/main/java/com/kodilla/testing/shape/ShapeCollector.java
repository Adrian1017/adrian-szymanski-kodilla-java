package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeCollector {
    List<Shape> shapeList = new ArrayList<>();

    public void addFigure( Shape shape){
        shapeList.add(shape);
    }
    public boolean removeFigure(Shape shape){
        if(shapeList.contains(shape)){
            shapeList.remove(shape);
            return true;
        }
      return false;
    }
    public Shape getFigure( int n){
        if( n >= 0 && n < shapeList.size()){
            return shapeList.get(n);
        }
     return null;
    }
    public String showFigures(){
        return  shapeList.stream().map( s -> s.getShapeName()).collect(Collectors.joining());
    }
}
