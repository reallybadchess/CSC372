import java.util.ArrayList;

public class Inventory {
    private ArrayList<Book> books;          // available books
    private ArrayList<Book> borrowedBooks;  // borrowed books

    public Inventory() {
        books = new ArrayList<Book>();
        borrowedBooks = new ArrayList<Book>();
    }

    // add a new book
    public boolean addBook(int id, String title, String author, String isbn, int numPages) {
        if (findBook(books, id) != null || findBook(borrowedBooks, id) != null) {
            return false;
        }
        Book newBook = new Book(id, title, author, isbn, numPages);
        books.add(newBook);
        return true;
    }

    // borrow a book
    public boolean borrowBook(int id) {
        Book book = findBook(books, id);
        if (book == null) {
            return false;
        }
        books.remove(book);
        borrowedBooks.add(book);
        return true;
    }

    // return a book
    public boolean returnBook(int id) {
        Book book = findBook(borrowedBooks, id);
        if (book == null) {
            return false;
        }
        borrowedBooks.remove(book);
        books.add(book);
        return true;
    }

    // print all books
    public void printAll() {
        if (books.size() == 0) {
            System.out.println("there are no books in the library.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            books.get(i).printBookInfo();
        }
    }

    // search by title
    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> results = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    // check if book is borrowed
    public boolean isBorrowed(int id) {
        return findBook(borrowedBooks, id) != null;
    }

    public int getMainInventoryCount() {
        return books.size();
    }

    public int getBorrowedCount() {
        return borrowedBooks.size();
    }

    // find a book by id
    private Book findBook(ArrayList<Book> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }
}