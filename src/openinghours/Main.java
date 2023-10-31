package openinghours;

import java.util.Scanner;

public class Main {
    private Menu menu;
    private FinancialData financialData;


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        StoreHours store = new StoreHours();
        financialData = new FinancialData();
        menu = new Menu(store, financialData);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            menu.showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menu.checkCurrentOpeningHours();
                    break;
                case 2:
                    menu.changeOpeningHours(scanner);
                    break;
                case 3:
                    if (menu.validatePassword())
                        menu.displayFinancialInformation();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}