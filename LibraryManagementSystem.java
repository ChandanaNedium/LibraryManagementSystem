package task5;

import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. User Section");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    adminModule();
                    break;
                case 2:
                    userModule();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // ADMIN MODULE
    static void adminModule() {

        System.out.print("Enter Admin Password: ");
        String pass = sc.next();

        if(pass.equals("admin123")) {

            while(true) {
                System.out.println("\n--- ADMIN MENU ---");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Back");

                int ch = sc.nextInt();

                if(ch == 1) {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    books.add(new Book(id, title, author));
                    System.out.println("Book added successfully!");

                } else if(ch == 2) {
                    viewBooks();
                } else {
                    return;
                }
            }

        } else {
            System.out.println("Wrong password!");
        }
    }

    // USER MODULE
    static void userModule() {

        while(true) {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Back");

            int ch = sc.nextInt();

            switch(ch) {

                case 1:
                    viewBooks();
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    for(Book b : books) {
                        if(b.title.equalsIgnoreCase(title)) {
                            System.out.println("Book Found: " + b.title + " by " + b.author);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int id = sc.nextInt();

                    for(Book b : books) {
                        if(b.id == id && !b.issued) {
                            b.issued = true;
                            System.out.println("Book issued successfully!");
                            return;
                        }
                    }
                    System.out.println("Book not available.");
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int rid = sc.nextInt();

                    for(Book b : books) {
                        if(b.id == rid && b.issued) {
                            b.issued = false;
                            System.out.println("Book returned successfully!");
                            return;
                        }
                    }
                    System.out.println("Invalid book ID.");
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // VIEW BOOKS
    static void viewBooks() {

        if(books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nBook List:");

        for(Book b : books) {
            System.out.println("ID: " + b.id + " | Title: " + b.title +
                               " | Author: " + b.author +
                               " | Issued: " + b.issued);
        }
    }
}
