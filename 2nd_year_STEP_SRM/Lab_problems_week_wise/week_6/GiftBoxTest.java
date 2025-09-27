// 🧪 LAB PROBLEM 6: Box and Gift Box Enhancement
// Topic: Using super in overridden methods

class Box {
    public void pack() {
        System.out.println("Packing items into the box...");
    }

    public void unpack() {
        System.out.println("Unpacking items from the box...");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack(); // call parent
        System.out.println("Adding gift wrap and ribbon!");
    }

    @Override
    public void unpack() {
        super.unpack(); // call parent
        System.out.println("Removing gift wrap and ribbon!");
    }
}

public class GiftBoxTest {
    public static void main(String[] args) {
        GiftBox g = new GiftBox();
        g.pack();
        g.unpack();
    }
}
