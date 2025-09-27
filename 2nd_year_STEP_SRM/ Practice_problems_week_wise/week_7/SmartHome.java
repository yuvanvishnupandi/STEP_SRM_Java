// PRACTICE PROBLEM 6: Smart Home - Safe Downcasting with instanceof

class SmartDevice {
    protected String name;

    public SmartDevice(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + " is now ON");
    }

    public void turnOff() {
        System.out.println(name + " is now OFF");
    }
}

class SmartLight extends SmartDevice {
    public SmartLight(String name) {
        super(name);
    }

    public void changeColor(String color) {
        System.out.println(name + " light color changed to " + color);
    }
}

class SmartSpeaker extends SmartDevice {
    public SmartSpeaker(String name) {
        super(name);
    }

    public void playMusic(String song) {
        System.out.println(name + " is playing song: " + song);
    }
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice d1 = new SmartLight("Philips Hue");
        SmartDevice d2 = new SmartSpeaker("Amazon Echo");

        d1.turnOn();
        d2.turnOn();

        if (d1 instanceof SmartLight) {
            SmartLight light = (SmartLight) d1;
            light.changeColor("Blue");
        }

        if (d2 instanceof SmartSpeaker) {
            SmartSpeaker speaker = (SmartSpeaker) d2;
            speaker.playMusic("Shape of You");
        }

        d1.turnOff();
        d2.turnOff();
    }
}
