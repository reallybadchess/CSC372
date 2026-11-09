public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int numPages;

    // default constructor
    public Book() {
        id = 0;
        title = "";
        author = "";
        isbn = "";
        numPages = 0;
    }

    // constructor with all fields
    public Book(int id, String title, String author, String isbn, int numPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numPages = numPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    // print book info
    public void printBookInfo() {
        System.out.println("id: " + id);
        System.out.println("title: " + title);
        System.out.println("author: " + author);
        System.out.println("isbn: " + isbn);
        System.out.println("pages: " + numPages);
        System.out.println();
    }
}