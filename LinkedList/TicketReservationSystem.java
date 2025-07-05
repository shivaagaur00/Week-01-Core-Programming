import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Ticket {
    String ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    public Ticket(String ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head;
    private Ticket tail;
    private int count;

    // Add ticket at end
    public void addTicket(String ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        count++;
    }

    // Remove ticket by ID
    public void removeTicket(String ticketId) {
        if (head == null) return;
        if (head.ticketId.equals(ticketId)) {
            if (head.next == head) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            count--;
            return;
        }
        Ticket prev = head;
        Ticket current = head.next;
        while (current != head && !current.ticketId.equals(ticketId)) {
            prev = current;
            current = current.next;
        }
        if (current != head) {
            prev.next = current.next;
            if (current == tail) {
                tail = prev;
            }
            count--;
        }
    }

    // Search by customer name
    public Ticket searchByCustomerName(String customerName) {
        if (head == null) return null;
        Ticket current = head;
        do {
            if (current.customerName.equals(customerName)) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    // Search by movie name
    public Ticket searchByMovieName(String movieName) {
        if (head == null) return null;
        Ticket current = head;
        do {
            if (current.movieName.equals(movieName)) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    // Display all tickets
    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }
        Ticket current = head;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Ticket ID\tCustomer\tMovie\t\tSeat\tBooking Time");
        do {
            System.out.println(current.ticketId + "\t" + current.customerName + "\t" + 
                             current.movieName + "\t" + current.seatNumber + "\t" + 
                             current.bookingTime.format(formatter));
            current = current.next;
        } while (current != head);
    }

    // Count tickets
    public int countTickets() {
        return count;
    }
}