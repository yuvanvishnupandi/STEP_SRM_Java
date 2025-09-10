// PRACTICE PROBLEM 5: Library & Book
class Book {
    String title, author, isbn;
    double price;
    int quantity;

    public Book(String title, String author, String isbn, double price, int quantity) {
        this.title = title; this.author = author; this.isbn = isbn;
        this.price = price; this.quantity = quantity;
    }

    public double getTotalValue() { return price * quantity; }
    public void displayBook() {
        System.out.println(title + " by " + author + " | ISBN: " + isbn + " | Price: " + price + " | Qty: " + quantity);
    }
}

class Library {
    String libraryName;
    Book[] books;
    int totalBooks = 0;

    public Library(String libraryName, int size) {
        this.libraryName = libraryName;
        books = new Book[size];
    }

    public void addBook(Book b) { books[totalBooks++] = b; }
    public void searchBook(String title) {
        for (int i = 0; i < totalBooks; i++)
            if (books[i].title.equalsIgnoreCase(title)) books[i].displayBook();
    }
    public void displayInventory() {
        System.out.println("Library: " + libraryName);
        for (int i = 0; i < totalBooks; i++) books[i].displayBook();
    }
    public void calculateTotalValue() {
        double sum = 0;
        for (int i = 0; i < totalBooks; i++) sum += books[i].getTotalValue();
        System.out.println("Total Library Value: " + sum);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library("City Library", 10);
        Book b1 = new Book("Java Basics", "James", "123", 500, 3);
        Book b2 = new Book("Python 101", "Guido", "124", 400, 5);

        lib.addBook(b1);
        lib.addBook(b2);

        lib.displayInventory();
        lib.searchBook("Python 101");
        lib.calculateTotalValue();
    }
}
