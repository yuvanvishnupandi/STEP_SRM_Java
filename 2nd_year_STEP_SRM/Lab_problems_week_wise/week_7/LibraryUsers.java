// File: LibraryUsers.java
// PROBLEM 4: University Library System - Upcasting

class LibraryUser {
    protected String name;
    public LibraryUser(String name) { this.name = name; }
    public void enterLibrary() {
        System.out.println(name + " entered the library.");
    }
    public void showInfo() {
        System.out.println("User: " + name);
    }
}

class StudentUser extends LibraryUser {
    private String studentId;
    public StudentUser(String name, String studentId) { super(name); this.studentId = studentId; }
    public void borrowBook() { System.out.println(name + " borrowed a book. ID: " + studentId); }
    public void useComputer() { System.out.println(name + " is using a library computer."); }
}

class FacultyUser extends LibraryUser {
    private String dept;
    public FacultyUser(String name, String dept) { super(name); this.dept = dept; }
    public void reserveBook() { System.out.println(name + " reserved a book for " + dept); }
    public void accessResearchDB() { System.out.println(name + " accessed research databases."); }
}

class GuestUser extends LibraryUser {
    public GuestUser(String name) { super(name); }
    public void browse() { System.out.println(name + " is browsing books (guest)."); }
}

public class LibraryUsers {
    public static void main(String[] args) {
        LibraryUser[] users = new LibraryUser[3];
        users[0] = new StudentUser("Alice", "S1001");
        users[1] = new FacultyUser("Dr. Roy", "Physics");
        users[2] = new GuestUser("Visitor");

        for (LibraryUser u : users) {
            u.enterLibrary();
            u.showInfo();
            // upcasting hides specialized methods; safe common use via LibraryUser reference
        }

        // To use specific actions, downcast after checking type
        LibraryUser p = new StudentUser("Bob", "S1002");
        p.enterLibrary();
        if (p instanceof StudentUser) {
            StudentUser s = (StudentUser) p;
            s.borrowBook();
            s.useComputer();
        }
    }
}
