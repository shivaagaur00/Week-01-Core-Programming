import java.util.Scanner;

public class InventoryItem {
    private int itemCode;
    private String itemName;
    private double price;

    public InventoryItem(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        double price = sc.nextDouble();
        int qty = sc.nextInt();
        InventoryItem item = new InventoryItem(code, name, price);
        item.displayDetails();
        System.out.println("Total Cost: " + item.calculateTotalCost(qty));
    }
}
