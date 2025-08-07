public class ValidateCreditCard {
    public static boolean isVisa(String card) {
        return card.matches("^4\d{15}$");
    }

    public static boolean isMasterCard(String card) {
        return card.matches("^5\d{15}$");
    }

    public static void main(String[] args) {
        System.out.println(isVisa("4123456789012345"));    // true
        System.out.println(isMasterCard("5123456789012345")); // true
    }
}