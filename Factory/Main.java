package Factory;

import Factory.ShapeFactory.Shape;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        
        Shape circle = shapeFactory.createShape("circle");
        circle.draw();

        Shape rectangle = shapeFactory.createShape("rectangle");
        rectangle.draw();

        Shape square = shapeFactory.createShape("square");
        square.draw();
    }
}
