import java.util.ArrayList;
import java.util.List;

class Book {
    private int bookId;
    private String title;
    private boolean isAvailable;

    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.isAvailable = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsUnavailable() {
        isAvailable = false;
    }

    public void markAsAvailable() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Library2 {
    private List<Book> books;

    public Library2() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void issueBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && book.isAvailable()) {
                book.markAsUnavailable();
                System.out.println("Book issued: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " is not available for issue.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && !book.isAvailable()) {
                book.markAsAvailable();
                System.out.println("Book returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " cannot be returned.");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class Library {
    public static void main(String[] args) {
        Library2 library = new Library2();

        Book book1 = new Book(1, "Introduction to Java");
        Book book2 = new Book(2, "Data Structures and Algorithms");
        Book book3 = new Book(3, "Design Patterns");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        library.issueBook(2);
        library.issueBook(2); // Trying to issue the same book again
        library.displayBooks();

        library.returnBook(2);
        library.displayBooks();
    }
}
