import java.util.*;
class Flight {
    String flightId, source, destination;
    double price;
    public Flight(String flightId, String source, String destination, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }
    public void display() {
        System.out.println(flightId + " : " + source + ":" + destination + ":" + price);
    }
}
class Booking {
    String passengerName;
    Flight flight;
    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }
    public void display() {
        System.out.print("Passenger: " + passengerName + ", ");
        flight.display();
    }
}
public class FlightBookingSystem {
    static List<Flight> flights = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Flight");
            System.out.println("2. Search Flights");
            System.out.println("3. Book Flight");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter Flight ID: ");
                String fno = sc.nextLine();
                System.out.print("Enter Source: ");
                String src = sc.nextLine();
                System.out.print("Enter Destination: ");
                String dst = sc.nextLine();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                flights.add(new Flight(fno, src, dst, price));
                System.out.println("Flight added");
            } else if (choice == 2) {
                System.out.print("Enter source:");
                String src = sc.nextLine();
                System.out.print("Enter destination: ");
                String dst = sc.nextLine();
                searchFlights(src, dst);
            } else if (choice == 3) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Enter flightID: ");
                String fno = sc.nextLine();
                bookFlight(name, fno);
            } else if (choice == 4) {
                viewBookings();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
    static void searchFlights(String src, String dst) {
        boolean found = false;
        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(src) && f.destination.equalsIgnoreCase(dst)) {
                f.display();
                found = true;
            }
        }
        if (!found) System.out.println("No flights found.");
    }
    static void bookFlight(String name, String flightId) {
        for (Flight f : flights) {
            if (f.flightId.equalsIgnoreCase(flightId)) {
                bookings.add(new Booking(name, f));
                System.out.println("Flight booked successfully!");
                return;
            }
        }
        System.out.println("Flight not found.");
    }
    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking b : bookings) {
                b.display();
            }
        }
    }
}
