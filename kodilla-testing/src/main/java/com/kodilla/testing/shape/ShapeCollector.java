package com.kodilla.testing.shape;
import java.util.ArrayList;

interface Shape {
    void getShapeName();
    void getField();
}

public class ShapeCollector extends Circle {
    private ShapeDrawer figure;
    private ArrayList<ShapeDrawer> shapeList=new ArrayList<>();

    public void addFigure(Shape shape){
        shapeList.add(new ShapeDrawer(shape));
    }
    public void removeFigure(Shape shape){}
    public void getFigure(int n){}
    public void showFigures(){}
    public int getShapeListSize(){
        return shapeList.size();
    }

    public ShapeCollector(ShapeDrawer figure){
        this.figure=figure;
    }
}
class Circle implements Shape{
    @Override
    public void getShapeName() {
        System.out.println("I am a circle");
    }
    @Override
    public void getField() {
    }
}
class Square implements Shape{


    @Override
    public void getShapeName() {

    }

    @Override
    public void getField() {

    }
}
class Triangle implements Shape {
    @Override
    public void getShapeName() {

    }

    @Override
    public void getField() {

    }
}

class ShapeDrawer{
    private Shape shape;

    public ShapeDrawer(Shape shape) {
        this.shape = shape;
    }
}



