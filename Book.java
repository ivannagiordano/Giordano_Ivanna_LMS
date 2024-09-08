package librarySystem;

/**
 * IVANNA GIORDANO
 * CEN 3024C - Software Development 1
 * September 8, 2024
 * Book.java
 * This class represents a book in the library collection.
 * Each book has a unique ID, a title, and an author.
 */
public class Book {
    private int id;
    private String title;
    private String author;

    /**
     * Constructor: Book
     * parameters: int id, String title, String author
     * purpose: Initializes a new Book object with a unique ID, title, and author.
     */
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    
    public String getAuthor() {
        return author;
    }

    /**
     * method: toString
     * parameters: none
     * return: String
     * purpose: Provides a string representation of the book in the format:
     *          "ID, Title, Author"
     */
    @Override
    public String toString() {
        return id + ", " + title + ", " + author;
    }
}
