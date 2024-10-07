package librarySystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Ivanna Giordano
 * CEN 3024C - Software Development 1
 * October 6, 2024
 * Library.java
 * This class manages a collection of books in a library, allowing for adding, removing, 
 * listing, and loading books from a file, as well as saving the collection to a file. Now newly adding to check out book and check in book. 
 */
public class Library {
    private List<Book> books;

    /**
     * Constructor: Library
     * parameters: none
     * purpose: Initializes an empty list of books to create a new library.
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * method: addBook
     * parameters: Book book
     * return: void
     * purpose: Adds a book to the collection and saves the list to a file.
     *          Displays a message indicating the book has been added.
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
        saveBooksToFile("books.txt");
    }

    /**
     * method: saveBooksToFile
     * parameters: String filename
     * return: void
     * purpose: Saves the list of books to a file. Writes each book's ID, title, and author to the file.
     */
    private void saveBooksToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                bw.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor());
                bw.newLine();
            }
            System.out.println("Books saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving books to file: " + e.getMessage());
        }
    }

    /**
     * method: removeBook
     * parameters: int id
     * return: void
     * purpose: Removes a book from the collection by its ID, saves the updated list to the file,
     *          and displays a message indicating if the book was removed.
     */
    public void removeBook(int id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                System.out.println("Book with ID " + id + " removed.");
                saveBooksToFile("books.txt");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    /**
     * method: listBooks
     * parameters: none
     * return: void
     * purpose: Lists all books currently in the library collection.
     *          Displays a message if the collection is empty.
     */
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the collection.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    /**
     * method: loadBooksFromFile
     * parameters: String filename
     * return: void
     * purpose: Loads books from a text file into the library collection. Each book is added
     *          to the list without saving it back to the file.
     */
    public void loadBooksFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                int id = Integer.parseInt(details[0].trim());
                String title = details[1].trim();
                String author = details[2].trim();
                Book book = new Book(id, title, author);
                books.add(book);  // Directly add to the list without saving to file
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading books from file: " + e.getMessage());
        }
    }

    public void removeBookByTitle(String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Book titled '" + title + "' removed.");
                saveBooksToFile("books.txt");
                return;
            }
        }
        System.out.println("Book titled '" + title + "' not found.");
    }
    
    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkOut();
                saveBooksToFile("books.txt");
                return;
            }
        }
        System.out.println("Book titled '" + title + "' not found.");
    }
    
    public void checkInBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkIn();
                saveBooksToFile("books.txt");
                return;
            }
        }
        System.out.println("Book titled '" + title + "' not found.");
    }   
    /**
     * method: addBookManually
     * parameters: int id, String title, String author
     * return: void
     * purpose: Manually adds a book with the provided details and saves the list to the file.
     */
    public void addBookManually(int id, String title, String author) {
        Book book = new Book(id, title, author);
        addBook(book);
    }
}
