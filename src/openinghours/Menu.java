package openinghours;

import java.util.Scanner;

public class Menu {
    private StoreHours store;
    private FinancialData financialData;

    public Menu(StoreHours store, FinancialData financialData) {
        this.store = store;
        this.financialData = financialData;
    }

    public void showMenu() {
        System.out.println("\nStore Opening Hours Menu:");
        System.out.println("1. Check current opening hours");
        System.out.println("2. Change opening hours");
        System.out.println("3. Display financial information");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void checkCurrentOpeningHours() {
        System.out.println("Current Opening Hours:");
        store.displayStoreHours();
    }

    public void changeOpeningHours(Scanner scanner) {
        System.out.print("Enter the day index (0-6) to change opening hours: ");
        int dayIndex = scanner.nextInt();
        scanner.nextLine(); // scanner bug

        System.out.print("Enter new opening hours: ");
        String newHours = scanner.nextLine();

        store.setOpeningHours(dayIndex, newHours);
        System.out.println("Opening hours updated.");
    }

    public boolean validatePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password: ");
        String input = scanner.nextLine();
        if (input.equals("harryharry")) {
            System.out.println("Password is correct. Access granted.");
            return true; // Return true to indicate that the password is correct.
        } else {
            System.out.println("Incorrect password, try again.");
            return false; // Return false to indicate that the password is incorrect.
        }
    }


    public void displayFinancialInformation() {
        double currentMonthEarnings = financialData.getCurrentMonthEarnings();
        int currentMonthCustomers = financialData.getCurrentMonthCustomers();

        System.out.println("Financial Information:");
        System.out.printf("Current Month Earnings: %.2f kr%n", + currentMonthEarnings);
        System.out.println("Current Month Customers: " + currentMonthCustomers);
    }
}

