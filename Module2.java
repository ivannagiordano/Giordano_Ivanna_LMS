package librarySystem;

import java.util.Scanner;

/**
 * IVANNA GIORDANO
 * CEN 3024C - Software Development 1
 * September 8, 2024
 * Module2.java
 * MAIN class for running the Library Management System (LMS).
 * This class contains the main method, which provides a console-based interface for the user 
 * to manage a library by listing, adding, and removing books from the collection.
 */
public class Module2 {
    public static void main(String[] args) {
        Library library = new Library();  // Create an instance of the Library class
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to capture user input
        
        // Load books from the "books.txt" file
        library.loadBooksFromFile("books.txt");
        
        // Menu loop to continuously present options to the user
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. List all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Remove a book by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            
            scanner.nextLine();  // Consume the newline character left by nextInt()
            
            switch (option) {
                case 1:
                	
                    // List all books currently in the library
                    library.listBooks();
                    break;
                case 2:
                	
                    // Prompt the user to input the details of a new book
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    
                    // Add the new book to the library
                    library.addBookManually(id, title, author);
                    break;
                case 3:
                    // Prompt the user to input the ID of the book to be removed
                    System.out.print("Enter book ID to remove: ");
                    int removeId = scanner.nextInt();
                    // Remove the specified book from the library
                    library.removeBook(removeId);
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting book management system.");
                    return;
                default:
                    // Handle invalid input
                    System.out.println("Invalid option. Please input as directed.");
            }
         
        }
    }
}
