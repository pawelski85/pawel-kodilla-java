package com.kodilla.testing.shape;
import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapeList=new ArrayList<>();

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }
    public void removeFigure(Shape shape){
        shapeList.remove(shape);
    }
    public Shape getFigure(int n){
        return shapeList.get(n);
    }
    public String showFigures(){
        return shapeList.toString();

    }
    public int getShapeListSize(){
        return shapeList.size();
    }
}






