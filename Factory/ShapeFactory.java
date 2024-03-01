package Factory;

public class ShapeFactory {

    public interface Shape {
        void draw();
    }

    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing circle");
        }
    }
    class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing rectangle");
        }
    }
    class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing square");
        }
    }

    public Shape createShape(String shapeType) {
        if(shapeType == null) {
            return null;
        } else if(shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
    
}
