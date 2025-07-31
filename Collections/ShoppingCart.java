import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Integer> prices = Map.of("Apple", 100, "Banana", 60, "Carrot", 40);
        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Banana", prices.get("Banana"));
        cart.put("Apple", prices.get("Apple"));
        cart.put("Carrot", prices.get("Carrot"));

        TreeMap<String, Integer> sortedByPrice = new TreeMap<>(Comparator.comparingInt(cart::get));
        sortedByPrice.putAll(cart);

        System.out.println("Sorted by Price: " + sortedByPrice);
    }
}