import java.util.*;

public class Member {
    private String name;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
        System.out.println(this.name + " borrowed book: " + book.getTitle());
    }

    public void showBorrowedBooks() {
        System.out.println("Books borrowed by " + this.name + ":");
        for (Book book : borrowedBooks) {
            book.showDetails();
        }
    }
}