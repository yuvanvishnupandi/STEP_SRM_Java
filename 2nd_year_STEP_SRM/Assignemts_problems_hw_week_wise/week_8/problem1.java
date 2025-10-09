Topic 1: Abstract Class with Abstract and Concrete Methods

// File: Shape.java
public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    public void displayInfo() {
        System.out.println("This is a shape with area and perimeter.");
    }
}

// File: Circle.java
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// File: Rectangle.java
public class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return length * breadth;
    }

    @Override
    public double perimeter() {
        return 2 * (length + breadth);
    }
}

// File: ShapeTest.java
public class ShapeTest {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        c.displayInfo();
        System.out.println("Circle Area: " + c.area());
        System.out.println("Circle Perimeter: " + c.perimeter());

        Shape r = new Rectangle(4, 6);
        r.displayInfo();
        System.out.println("Rectangle Area: " + r.area());
        System.out.println("Rectangle Perimeter: " + r.perimeter());
    }
}
