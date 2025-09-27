// 🧪 LAB PROBLEM 4: Color Hierarchy Chain
// Topic: Multilevel Inheritance

class Color {
    protected String name;

    public Color(String name) {
        this.name = name;
        System.out.println("Color constructor");
    }
}

class PrimaryColor extends Color {
    protected int intensity;

    public PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor");
    }
}

class RedColor extends PrimaryColor {
    private String shade;

    public RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("RedColor constructor");
    }

    public void showDetails() {
        System.out.println("Name: " + name + ", Intensity: " + intensity + ", Shade: " + shade);
    }
}

public class ColorTest {
    public static void main(String[] args) {
        RedColor red = new RedColor("Red", 90, "Dark Red");
        red.showDetails();
    }
}
