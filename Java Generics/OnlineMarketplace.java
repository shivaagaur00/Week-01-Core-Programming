class BookCategory {}
class ClothingCategory {}
class GadgetCategory {}

class Product<T> {
    String name;
    double price;
    T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String toString() { return name + " - " + price; }
}

public class OnlineMarketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
        System.out.println(product + " after discount");
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Book", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-shirt", 300, new ClothingCategory());
        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
    }
}
