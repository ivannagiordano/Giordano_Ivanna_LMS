package librarySystem;

import java.util.Scanner;

/**
 * IVANNA GIORDANO
 * CEN 3024C - Software Development 1
 * October 6, 2024
 * Module2.java
 * MAIN class for running the Library Management System (LMS).
 * This class contains the main method, which provides a console-based interface for the user 
 * to manage a library by listing, removing a book by ID, removing a book by title, checking out a book by title, amd checking in a book by title from the collection.
 */
public class Module2 {
    public static void main(String[] args) {
        Library library = new Library(); 
        Scanner scanner = new Scanner(System.in);  
        
        // Ask the user for a file name and load books from the file
        System.out.print("Enter the file name to load books from: ");
        String filename = scanner.nextLine();
        library.loadBooksFromFile(filename);

        // Menu loop to continuously present options to the user with updated information
        while (true) {
            // Display menu options
            System.out.println("\nLibrary Management System - Menu");
            System.out.println("1. List all books");
            System.out.println("2. Remove a book by ID (barcode)");
            System.out.println("3. Remove a book by title");
            System.out.println("4. Check out a book by title");
            System.out.println("5. Check in a book by title");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            // Read user option
            int option = scanner.nextInt();
            scanner.nextLine(); 
            
            // Process the user's choice
            switch (option) {
                case 1:
                    // List all books currently in the library
                    System.out.println("\nBooks in the library:");
                    library.listBooks();
                    break;
                    
                case 2:
                    // Ask the user for a book ID (barcode) to remove
                    System.out.print("Enter the book ID (barcode) to remove: ");
                    int barcode = scanner.nextInt();
                    library.removeBook(barcode);
                    library.listBooks();  // Re-print the library contents after removal
                    break;
                    
                case 3:
                    // Ask the user for a title to remove a book by title
                    System.out.print("Enter the book title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    library.removeBookByTitle(titleToRemove);
                    library.listBooks();  // Re-print the library contents after removal
                    break;
                    
                case 4:
                    // Ask the user for a title to check out a book
                    System.out.print("Enter the book title to check out: ");
                    String titleToCheckOut = scanner.nextLine();
                    library.checkOutBook(titleToCheckOut);
                    library.listBooks();  // Re-print the library contents after check-out
                    break;
                    
                case 5:
                    // Ask the user for a title to check in a book
                    System.out.print("Enter the book title to check in: ");
                    String titleToCheckIn = scanner.nextLine();
                    library.checkInBook(titleToCheckIn);
                    library.listBooks();  // Re-print the library contents after check-in
                    break;
                    
                case 6:
                    // Exit the program
                    System.out.println("Exiting the Library Management System.");
                    return;  // End the main method and exit the loop
                    
                default:
                    // Handle invalid input
                    System.out.println("Invalid option. Please choose a valid option from the menu.");
            }
        }
    }
}
