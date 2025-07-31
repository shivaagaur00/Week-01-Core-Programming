import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Map<String, Integer> voteMap = new HashMap<>();
        String[] votes = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Alice"};
        for (String vote : votes) {
            voteMap.put(vote, voteMap.getOrDefault(vote, 0) + 1);
        }

        Map<String, Integer> sortedVotes = new TreeMap<>(voteMap);
        System.out.println("Sorted Votes: " + sortedVotes);

        Map<String, Integer> insertionOrder = new LinkedHashMap<>();
        for (String vote : votes) {
            insertionOrder.put(vote, insertionOrder.getOrDefault(vote, 0) + 1);
        }
        System.out.println("Insertion Order: " + insertionOrder);
    }
}