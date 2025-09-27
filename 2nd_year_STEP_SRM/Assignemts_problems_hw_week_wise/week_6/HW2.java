// 🧪 HW PROBLEM 2: Tool Access Levels
// Topic: Access Modifiers in Inheritance

class Tool {
    private String name = "PrivateTool";   // private field
    protected String type = "ProtectedTool"; // protected field
    public String category = "PublicTool"; // public field

    public String getName() {  // getter for private field
        return name;
    }
}

class Hammer extends Tool {
    public void showAccess() {
        // System.out.println(name); ❌ not accessible (private)
        System.out.println("Protected field: " + type); // ✅ accessible
        System.out.println("Public field: " + category); // ✅ accessible
        System.out.println("Private field (via getter): " + getName()); // ✅
    }
}

public class HW2 {
    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.showAccess();
    }
}
