public class Outer {
    private String message = "Hello from the Outer class!";

    // Non-static member inner class
    class Inner {
        public void display() {
            // Can access the private member of the Outer class
            System.out.println("Inner class accessing message: " + message);
        }
    }

    public static void main(String[] args) {
        // Create an instance of the Outer class
        Outer outerObj = new Outer();

        // Create an instance of the Inner class using the outer class instance
        Outer.Inner innerObj = outerObj.new Inner();

        // Call the method of the inner class
        innerObj.display();
    }
}