import java.util.Objects;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    public static void main(String[] args) {
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book3 = book1;

        System.out.println("--- Comparing book1 and book2 (different objects, same content) ---");
        System.out.println("Using == : " + (book1 == book2));
        System.out.println("Using .equals(): " + book1.equals(book2));

        System.out.println("\n--- Comparing book1 and book3 (same object reference) ---");
        System.out.println("Using == : " + (book1 == book3));
        System.out.println("Using .equals(): " + book1.equals(book3));
    }
}