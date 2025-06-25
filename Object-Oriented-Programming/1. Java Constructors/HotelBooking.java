public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    @Override
    public String toString() {
        return "HotelBooking [guestName=" + guestName + ", roomType=" + roomType + ", nights=" + nights + "]";
    }

    public static void main(String[] args) {
        HotelBooking defaultBooking = new HotelBooking();
        HotelBooking customBooking = new HotelBooking("Alice", "Suite", 5);
        HotelBooking copiedBooking = new HotelBooking(customBooking);
        System.out.println(defaultBooking);
        System.out.println(customBooking);
        System.out.println("Copied: " + copiedBooking);
    }
}
