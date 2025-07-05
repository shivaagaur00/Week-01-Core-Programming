import java.util.ArrayList;
import java.util.List;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friends;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    // Add user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Add friend connection
    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            if (!user1.friends.contains(userId2)) {
                user1.friends.add(userId2);
            }
            if (!user2.friends.contains(userId1)) {
                user2.friends.add(userId1);
            }
        }
    }

    // Remove friend connection
    public void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userId2));
            user2.friends.remove(Integer.valueOf(userId1));
        }
    }

    // Find mutual friends
    public List<Integer> findMutualFriends(int userId1, int userId2) {
        List<Integer> mutualFriends = new ArrayList<>();
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            for (int friendId : user1.friends) {
                if (user2.friends.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    // Display friends of a user
    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ":");
            for (int friendId : user.friends) {
                User friend = findUser(friendId);
                if (friend != null) {
                    System.out.println(friend.userId + ": " + friend.name);
                }
            }
        }
    }

    // Search by name
    public User searchByName(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search by user ID
    public User searchByUserId(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Count friends
    public int countFriends(int userId) {
        User user = findUser(userId);
        return user != null ? user.friends.size() : 0;
    }

    // Helper method to find user
    private User findUser(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all users
    public void displayAllUsers() {
        User current = head;
        System.out.println("User ID\tName\tAge\tNumber of Friends");
        while (current != null) {
            System.out.println(current.userId + "\t" + current.name + "\t" + current.age + "\t" + current.friends.size());
            current = current.next;
        }
    }
}