import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory library = new Inventory();
        int choice = 0;

        try {
            while (choice != 6) {
                printMenu();
                choice = readInt(input, "enter your choice: ");

                switch (choice) {
                    case 1:
                        addBook(input, library);
                        break;
                    case 2:
                        borrowBook(input, library);
                        break;
                    case 3:
                        returnBook(input, library);
                        break;
                    case 4:
                        searchBooks(input, library);
                        break;
                    case 5:
                        library.printAll();
                        break;
                    case 6:
                        System.out.println("exiting the program. goodbye!");
                        break;
                    default:
                        System.out.println("invalid option. please enter a number from 1 to 6.");
                }
            }
        } catch (NoSuchElementException e) {
            // input ended
            System.out.println("\nno more input. exiting the program. goodbye!");
        }

        input.close();
    }

    // show menu
    public static void printMenu() {
        System.out.println();
        System.out.println("1. add book       3. return book       5. print all books");
        System.out.println("2. borrow book    4. search by title   6. exit");
    }

    // add book
    public static void addBook(Scanner input, Inventory library) {
        int id = readInt(input, "enter book id: ");
        System.out.print("enter title: ");
        String title = input.nextLine();
        System.out.print("enter author: ");
        String author = input.nextLine();
        System.out.print("enter isbn: ");
        String isbn = input.nextLine();
        int pages = readInt(input, "enter number of pages: ");

        if (library.addBook(id, title, author, isbn, pages)) {
            System.out.println("book added to the library.");
        } else {
            System.out.println("a book with id " + id + " already exists. book was not added.");
        }
    }

    // borrow book
    public static void borrowBook(Scanner input, Inventory library) {
        int id = readInt(input, "enter the id of the book to borrow: ");

        if (library.isBorrowed(id)) {
            System.out.println("sorry, that book is already borrowed.");
        } else if (library.borrowBook(id)) {
            System.out.println("book successfully borrowed.");
        } else {
            System.out.println("book with id " + id + " was not found.");
        }
    }

    // return book
    public static void returnBook(Scanner input, Inventory library) {
        if (library.getBorrowedCount() == 0) {
            System.out.println("there are no borrowed books to return.");
            return;
        }

        int id = readInt(input, "enter the id of the book to return: ");

        if (library.returnBook(id)) {
            System.out.println("book successfully returned.");
        } else {
            System.out.println("book with id " + id + " is not in the lending list.");
        }
    }

    // search books
    public static void searchBooks(Scanner input, Inventory library) {
        System.out.print("enter full or partial title: ");
        String title = input.nextLine();

        ArrayList<Book> results = library.searchByTitle(title);
        if (results.size() == 0) {
            System.out.println("no matching book found.");
        } else {
            System.out.println("found " + results.size() + " book(s):");
            for (int i = 0; i < results.size(); i++) {
                results.get(i).printBookInfo();
            }
        }
    }

    // read a number
    public static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("invalid input. please enter a whole number.");
            }
        }
    }
}