// 🧪 PROBLEM 4: University Library System
// Concept: Upcasting

class LibraryUser {
    String name;
    LibraryUser(String name){ this.name = name; }
    void enter() { System.out.println(name + " enters the library"); }
}

class Student extends LibraryUser {
    Student(String name){ super(name); }
    void borrowBook() { System.out.println(name + " borrows books"); }
}

class Faculty extends LibraryUser {
    Faculty(String name){ super(name); }
    void reserveBook() { System.out.println(name + " reserves books"); }
}

class Guest extends LibraryUser {
    Guest(String name){ super(name); }
    void browseBooks() { System.out.println(name + " is browsing books"); }
}

public class Problem4 {
    public static void main(String[] args) {
        LibraryUser[] users = {
            new Student("Alice"),
            new Faculty("Bob"),
            new Guest("Charlie")
        };

        for(LibraryUser user : users) {
            user.enter(); // Upcasting: LibraryUser reference
        }
    }
}
