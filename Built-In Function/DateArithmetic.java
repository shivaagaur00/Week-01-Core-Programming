import java.time.LocalDate;
import java.util.Scanner;
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        LocalDate date = LocalDate.parse(input);
        LocalDate added = date.plusDays(7).plusMonths(1).plusYears(2);
        LocalDate finalDate = added.minusWeeks(3);

        System.out.println("Original Date: " + date);
        System.out.println("After Addition: " + added);
        System.out.println("Final Date after Subtracting 3 Weeks: " + finalDate);
    }
}
