// Problem 3: Library BookManagement 
class Book {
    String title, author, isbn;
    boolean isAvailable;

    Book() {
        this("", "", "", true);
    }

    Book(String title, String author) {
        this(title, author, "N/A", true);
    }

    Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    void borrowBook() {
        if (isAvailable) isAvailable = false;
    }

    void returnBook() {
        isAvailable = true;
    }

    void displayBookInfo() {
        System.out.println("Title: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Available: " + isAvailable);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("The Hobbit", "Tolkien", "12345", true);

        b2.borrowBook();
        b3.borrowBook();
        b3.returnBook();

        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}