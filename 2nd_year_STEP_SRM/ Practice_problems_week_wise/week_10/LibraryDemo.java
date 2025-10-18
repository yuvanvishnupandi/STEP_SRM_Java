public class LibraryDemo {
    public static void main(String[] args) {
        Library lib = new Library("Central City");

        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book b2 = new Book("1984", "George Orwell", "9780451524935");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        System.out.println();
        lib.showBooks();
        System.out.println();

        Member mem1 = new Member("Ravi");

        mem1.borrowBook(b1);
        mem1.borrowBook(b3);

        System.out.println();
        mem1.showBorrowedBooks();
    }
}