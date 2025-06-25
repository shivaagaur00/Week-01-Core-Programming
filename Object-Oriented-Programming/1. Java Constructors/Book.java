public class Book {
    String title;
    String author;
    double price;
    boolean availability;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.availability = true;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }

    // Borrow method
    public boolean borrow() {
        if (availability) {
            availability = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", price=" + price + ", available=" + availability + "]";
    }

    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book customBook = new Book("The Alchemist", "Paulo Coelho", 199.99);
        System.out.println(defaultBook);
        System.out.println(customBook);
        System.out.println("Borrowing customBook: " + customBook.borrow());
        System.out.println(customBook);
    }
}
