public class ValidateIPAddress {
    public static boolean isValidIP(String ip) {
        return ip.matches("((25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)(\.|$)){4}");
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1"));   // true
        System.out.println(isValidIP("256.100.1.1"));   // false
    }
}