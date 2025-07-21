import java.util.*;

abstract class WarehouseItem {
    String name;
    public WarehouseItem(String name) { this.name = name; }
    public String toString() { return name; }
}

class Electronics extends WarehouseItem { public Electronics(String name) { super(name); } }
class Groceries extends WarehouseItem { public Groceries(String name) { super(name); } }
class Furniture extends WarehouseItem { public Furniture(String name) { super(name); } }

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) { items.add(item); }
    public void displayItems() {
        displayItemsWildcard(items);
    }
    public void displayItemsWildcard(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class WarehouseManagement {
    public static void main(String[] args) {
        Storage<Electronics> electronics = new Storage<>();
        electronics.addItem(new Electronics("Laptop"));
        electronics.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceries = new Storage<>();
        groceries.addItem(new Groceries("Rice"));
        groceries.addItem(new Groceries("Pasta"));

        electronics.displayItems();
        groceries.displayItems();
    }
}
