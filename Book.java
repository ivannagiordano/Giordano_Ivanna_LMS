package librarySystem;
import java.time.LocalDate;

/**
 * IVANNA GIORDANO
 * CEN 3024C - Software Development 1
 * October 6, 2024
 * Book.java
 * This class represents a book in the library collection.
 * Each book has a unique ID, a title, and an author, and due date when check out. 
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String status;
    private LocalDate dueDate;

    /**
     * Constructor: Book
     * parameters: int id, String title, String author
     * purpose: Initializes a new Book object with a unique ID, title, and author.
     */
    
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = "checked in";
        this.dueDate = null;
    
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
    
    public void checkOut() {
        if (status.equals("checked out")) {
            System.out.println("Book is already checked out.");
        } else {
            this.status = "checked out";
            this.dueDate = LocalDate.now().plusWeeks(4);  // Due date is 4 weeks
            System.out.println("Book checked out. Due date: " + dueDate);
        }
    }

    public void checkIn() {
        if (status.equals("checked in")) {
            System.out.println("Book is already checked in.");
        } else {
            this.status = "checked in";
            this.dueDate = null;  // Reset due date
            System.out.println("Book checked in.");
        }
    }
    

    /**
     * method: toString
     * parameters: none
     * return: String
     * purpose: Provides a string representation of the book in the required format
     *          "ID, Title, Author" - also now adding status, due date- 
     */
    @Override
    public String toString() {
    	String dueDateString = (dueDate != null) ? dueDate.toString() : "None";
        return id + ", " + title + ", " + author + ", Status: " + status + ", Due Date: " + dueDateString;
    }


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
}
