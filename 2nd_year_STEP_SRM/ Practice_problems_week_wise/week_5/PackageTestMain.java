package com.company.main;
import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(5, "Hi", 15.5, false);
        System.out.println(obj.publicField);
        obj.publicMethod();
    }
}
java
Copy code
package com.company.extended;
import com.company.security.AccessModifierDemo;

public class ExtendedDemo extends AccessModifierDemo {
    public ExtendedDemo(int p, String d, double pr, boolean pub) {
        super(p, d, pr, pub);
    }

    public void testInheritedAccess() {
        System.out.println(protectedField);
        publicMethod();
    }

    protected void protectedMethod() {
        System.out.println("Overridden protected method");
    }

    public static void main(String[] args) {
        ExtendedDemo child = new ExtendedDemo(1, "Child", 2.2, true);
        child.testInheritedAccess();
    }
}