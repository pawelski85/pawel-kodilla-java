package com.kodilla.testing.shape;
import java.util.ArrayList;

interface Shape {
    String getShapeName();
    void getField();
}
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

class Circle implements Shape{
    String name="circle";
    @Override
    public String getShapeName() {
        return name;
    }
    @Override
    public void getField() {
    }

    @Override
    public String toString() {
        return name;
    }
}
class Square implements Shape {
    String name="square";
    @Override
    public String getShapeName() {
        return name;
    }
    @Override
    public void getField() {
    }

    @Override
    public String toString() {
        return name;
    }
}
class Triangle implements Shape {
    String name="triangle";
    @Override
    public String getShapeName() {
        return name;
    }
    @Override
    public void getField() {
    }

    @Override
    public String toString() {
        return name;
    }
}






