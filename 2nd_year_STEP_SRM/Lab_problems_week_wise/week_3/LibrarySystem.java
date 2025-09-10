class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int counter = 0;

    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    private static String generateBookId() {
        counter++;
        return "B" + String.format("%03d", counter);
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
        } else System.out.println("Book not available");
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println(bookId + " | " + title + " | " + author + " | Available: " + isAvailable);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBookId() {
        return bookId;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount = 0;
    private static int counter = 0;

    public Member(String memberName, int maxBooks) {
        this.memberId = generateMemberId();
        this.memberName = memberName;
        this.booksIssued = new String[maxBooks];
    }

    private static String generateMemberId() {
        counter++;
        return "M" + String.format("%03d", counter);
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.issueBook();
            booksIssued[bookCount++] = book.getBookId();
        } else System.out.println("Book unavailable for " + memberName);
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        booksIssued[i] = null;
                        break;
                    }
                }
                break;
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = new Book[2];
        books[0] = new Book("Java Basics", "James");
        books[1] = new Book("Python Guide", "Guido");

        Member m1 = new Member("Alice", 3);
        Member m2 = new Member("Bob", 3);

        m1.borrowBook(books[0]);
        m2.borrowBook(books[0]);
        m1.returnBook("B001", books);
        m2.borrowBook(books[0]);

        for (Book b : books) b.displayBookInfo();
        System.out.println("Available Books: " + Book.getAvailableBooks());
    }
}
