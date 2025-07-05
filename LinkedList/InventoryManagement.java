class InventoryItem {
    String itemName;
    String itemId;
    int quantity;
    double price;
    InventoryItem next;

    public InventoryItem(String itemName, String itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private InventoryItem head;

    // Add at beginning
    public void addAtBeginning(String itemName, String itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    public void addAtEnd(String itemName, String itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        InventoryItem current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    // Add at position
    public void addAtPosition(int pos, String itemName, String itemId, int quantity, double price) {
        if (pos == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        InventoryItem current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newItem.next = current.next;
        current.next = newItem;
    }

    // Remove by item ID
    public void removeByItemId(String itemId) {
        if (head == null) return;
        if (head.itemId.equals(itemId)) {
            head = head.next;
            return;
        }
        InventoryItem current = head;
        while (current.next != null && !current.next.itemId.equals(itemId)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Update quantity
    public void updateQuantity(String itemId, int newQuantity) {
        InventoryItem item = searchByItemId(itemId);
        if (item != null) {
            item.quantity = newQuantity;
        }
    }

    // Search by item ID
    public InventoryItem searchByItemId(String itemId) {
        InventoryItem current = head;
        while (current != null) {
            if (current.itemId.equals(itemId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search by item name
    public InventoryItem searchByItemName(String itemName) {
        InventoryItem current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Calculate total value
    public double calculateTotalValue() {
        double total = 0;
        InventoryItem current = head;
        while (current != null) {
            total += current.price * current.quantity;
            current = current.next;
        }
        return total;
    }

    // Sort by item name (bubble sort)
    public void sortByItemName() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            InventoryItem prev = null;
            InventoryItem current = head;
            InventoryItem next = head.next;
            while (next != null) {
                if (current.itemName.compareTo(next.itemName) > 0) {
                    if (prev != null) {
                        prev.next = next;
                    } else {
                        head = next;
                    }
                    current.next = next.next;
                    next.next = current;
                    prev = next;
                    swapped = true;
                } else {
                    prev = current;
                }
                current = prev.next;
                next = current != null ? current.next : null;
            }
        } while (swapped);
    }

    // Display all items
    public void displayAll() {
        InventoryItem current = head;
        System.out.println("Item ID\tItem Name\tQuantity\tPrice");
        while (current != null) {
            System.out.println(current.itemId + "\t" + current.itemName + "\t" + current.quantity + "\t" + current.price);
            current = current.next;
        }
    }
}