import java.util.*;

class DigitalBookSelF {
    private List<String> bookshelf;

    public DigitalBookSelF() {
        bookshelf = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        String entry = title + " - " + author;
        bookshelf.add(entry);
    }

    public void sortBooksAlphabetically() {
        for (int i = 0; i < bookshelf.size() - 1; i++) {
            for (int j = i + 1; j < bookshelf.size(); j++) {
                if (bookshelf.get(i).compareTo(bookshelf.get(j)) > 0) {
                    String temp = bookshelf.get(i);
                    bookshelf.set(i, bookshelf.get(j));
                    bookshelf.set(j, temp);
                }
            }
        }
    }

    public List<String> searchByAuthor(String author) {
        List<String> result = new ArrayList<>();
        for (String book : bookshelf) {
            String[] temp = book.split(" - ");
            if (temp.length > 1 && temp[1].equals(author)) {
                result.add(temp[0]);
            }
        }
        return result;
    }

    public String[] exportBookshelf() {
        String[] result = new String[bookshelf.size()];
        for (int i = 0; i < bookshelf.size(); i++) {
            result[i] = bookshelf.get(i);
        }
        return result;
    }

    public void displayBooks() {
        for (String book : bookshelf) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DigitalBookSelF bb = new DigitalBookSelF();
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String[] parts = sc.nextLine().split(" ");
            String title = parts[0];
            String author = parts[1];
            bb.addBook(title, author);
        }
        System.out.println("All Books:");
        bb.displayBooks();
        bb.sortBooksAlphabetically();
        bb.displayBooks();
        String Author = sc.next();
        List<String> bookByAuthor = bb.searchByAuthor(Author);
        for (String b : bookByAuthor) {
            System.out.println(b);
        }
        String[] exported = bb.exportBookshelf();
        System.out.println(Arrays.toString(exported));
    }
}