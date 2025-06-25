public class Library {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public Library() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.available = true;
    }
    public Library(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }

    public static void main(String[] args) {
        Library[] library = {
            new Library("The Great Gatsby", "F. Scott Fitzgerald", 10.99),
            new Library("1984", "George Orwell", 8.99),
            new Library("To Kill a Mockingbird", "Harper Lee", 12.50)
        };

        System.out.println("Library Books:");
        for (Library book : library) {
            System.out.println(book);
        }

        System.out.println("\nBorrowing '1984':");
        library[1].borrow();
        System.out.println(library[1]);

        System.out.println("\nTrying to borrow '1984' again:");
        library[1].borrow();

        System.out.println("\nCurrent Library Status:");
        for (Library book : library) {
            System.out.println(book);
        }
    }
}
