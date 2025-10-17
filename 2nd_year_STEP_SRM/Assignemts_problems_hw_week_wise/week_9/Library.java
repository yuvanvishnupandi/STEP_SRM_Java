import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Book class (must also implement Cloneable for deep cloning)
class Book implements Cloneable {
    private String title;

    public Book(String title) { this.title = title; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() { return "Book[Title='" + title + "']"; }
}

// Library class that will be cloned
public class Library implements Cloneable {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) { this.books.add(book); }
    public List<Book> getBooks() { return books; }
    
    @Override
    public String toString() {
        return "Library[Name='" + name + "', Books=" + books + "]";
    }

    // Performs a shallow copy
    public Library shallowClone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    // Performs a deep copy
    public Library deepClone() throws CloneNotSupportedException {
        Library clonedLibrary = new Library(this.name);
        // Manually clone each book in the list [cite: 41]
        for (Book book : this.books) {
            clonedLibrary.addBook((Book) book.clone());
        }
        return clonedLibrary;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        // 1. Create original library
        Library originalLibrary = new Library("City Central Library");
        originalLibrary.addBook(new Book("The Java Handbook"));
        originalLibrary.addBook(new Book("Data Structures in C++"));
        
        // 2. Perform shallow clone
        Library shallowClonedLibrary = (Library) originalLibrary.clone();

        // 3. Perform deep clone
        Library deepClonedLibrary = originalLibrary.deepClone();

        System.out.println("--- Initial State ---");
        System.out.println("Original:  " + originalLibrary);
        System.out.println("Shallow:   " + shallowClonedLibrary);
        System.out.println("Deep:      " + deepClonedLibrary);

        // 4. Modify a book in the shallow cloned library
        shallowClonedLibrary.getBooks().get(0).setTitle("Advanced Java");

        System.out.println("\n--- After Modifying Shallow Clone ---");
        System.out.println("Original:  " + originalLibrary); // Original is affected
        System.out.println("Shallow:   " + shallowClonedLibrary);
        System.out.println("Deep:      " + deepClonedLibrary); // Deep clone is unaffected

        // 5. Modify a book in the deep cloned library
        deepClonedLibrary.getBooks().get(1).setTitle("Advanced Data Structures");
        
        System.out.println("\n--- After Modifying Deep Clone ---");
        System.out.println("Original:  " + originalLibrary); // Original is unaffected
        System.out.println("Shallow:   " + shallowClonedLibrary);
        System.out.println("Deep:      " + deepClonedLibrary);
    }
}