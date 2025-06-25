class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}
public class BookTest {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-0-123456-47-2", "Java Mastery", "Subhankar");
        ebook.displayBookInfo();
        ebook.setAuthor("Sahoo");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}
