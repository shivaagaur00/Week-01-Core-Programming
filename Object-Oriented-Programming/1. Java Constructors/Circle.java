public class Circle {
    double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Constructor chaining
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(7.5);
        System.out.println(defaultCircle);
        System.out.println(customCircle);
    }
}
