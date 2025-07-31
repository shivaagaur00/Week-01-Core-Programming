import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("123", 1000);
        accounts.put("456", 1500);
        accounts.put("789", 800);

        TreeMap<String, Integer> sortedByBalance = new TreeMap<>((a, b) -> accounts.get(b) - accounts.get(a));
        sortedByBalance.putAll(accounts);
        System.out.println("Sorted Accounts: " + sortedByBalance);

        Queue<String> withdrawalRequests = new LinkedList<>(Arrays.asList("456", "123"));
        while (!withdrawalRequests.isEmpty()) {
            String acc = withdrawalRequests.poll();
            System.out.println("Processing withdrawal for account: " + acc);
        }
    }
}