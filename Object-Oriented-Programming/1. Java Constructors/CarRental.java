public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 50.0;

    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    @Override
    public String toString() {
        return "CarRental [customerName=" + customerName + ", carModel=" + carModel + ", rentalDays=" + rentalDays + ", totalCost=" + calculateTotalCost() + "]";
    }

    public static void main(String[] args) {
        CarRental defaultRental = new CarRental();
        CarRental customRental = new CarRental("Bob", "Sedan", 3);
        System.out.println(defaultRental);
        System.out.println(customRental);
        System.out.println("Total cost for customRental: " + customRental.calculateTotalCost());
    }
}
