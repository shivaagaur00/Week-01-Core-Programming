class Book {
    String title;
    String author;
    String genre;
    String bookId;
    boolean available;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, String bookId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = true;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head;
    private Book tail;
    private int count;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, String bookId) {
        Book newBook = new Book(title, author, genre, bookId);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, String bookId) {
        Book newBook = new Book(title, author, genre, bookId);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    // Add at position
    public void addAtPosition(int pos, String title, String author, String genre, String bookId) {
        if (pos == 1) {
            addAtBeginning(title, author, genre, bookId);
            return;
        }
        if (pos > count + 1) {
            System.out.println("Position out of bounds");
            return;
        }
        Book newBook = new Book(title, author, genre, bookId);
        Book current = head;
        for (int i = 1; i < pos - 1; i++) {
            current = current.next;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        } else {
            tail = newBook;
        }
        current.next = newBook;
        count++;
    }

    // Remove by book ID
    public void removeByBookId(String bookId) {
        if (head == null) return;
        if (head.bookId.equals(bookId)) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            count--;
            return;
        }
        Book current = head;
        while (current != null && !current.bookId.equals(bookId)) {
            current = current.next;
        }
        if (current == null) return;
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        count--;
    }

    // Search by title
    public Book searchByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search by author
    public Book searchByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equals(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Update availability
    public void updateAvailability(String bookId, boolean available) {
        Book current = head;
        while (current != null) {
            if (current.bookId.equals(bookId)) {
                current.available = available;
                return;
            }
            current = current.next;
        }
    }

    // Display forward
    public void displayForward() {
        Book current = head;
        System.out.println("Book ID\tTitle\tAuthor\tGenre\tAvailable");
        while (current != null) {
            System.out.println(current.bookId + "\t" + current.title + "\t" + current.author + "\t" + current.genre + "\t" + current.available);
            current = current.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Book current = tail;
        System.out.println("Book ID\tTitle\tAuthor\tGenre\tAvailable");
        while (current != null) {
            System.out.println(current.bookId + "\t" + current.title + "\t" + current.author + "\t" + current.genre + "\t" + current.available);
            current = current.prev;
        }
    }

    // Count books
    public int countBooks() {
        return count;
    }
}