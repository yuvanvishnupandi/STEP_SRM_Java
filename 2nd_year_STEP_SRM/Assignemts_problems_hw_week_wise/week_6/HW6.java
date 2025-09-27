// 🧪 HW PROBLEM 6: Weather System Hierarchy
// Topic: Complete Inheritance Implementation

class Weather {
    Weather() {
        System.out.println("Weather constructor");
    }

    void showWeather() {
        System.out.println("General weather");
    }
}

class Storm extends Weather {
    Storm() {
        super();
        System.out.println("Storm constructor");
    }

    @Override
    void showWeather() {
        System.out.println("Stormy weather");
    }
}

class Thunderstorm extends Storm {
    Thunderstorm() {
        super();
        System.out.println("Thunderstorm constructor");
    }

    @Override
    void showWeather() {
        System.out.println("Thunderstorm with lightning!");
    }
}

class Sunshine extends Weather {
    Sunshine() {
        super();
        System.out.println("Sunshine constructor");
    }

    @Override
    void showWeather() {
        System.out.println("Bright sunshine");
    }
}

public class HW6 {
    public static void main(String[] args) {
        Weather[] conditions = { new Thunderstorm(), new Sunshine() };

        System.out.println("\nWeather Reports:");
        for (Weather w : conditions) {
            w.showWeather();
        }
    }
}
