/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tvseriesmanagement;

/**
 *
 * @author Thabang Mathuloe
 */
import java.util.Scanner;

public class TVSeriesManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SeriesService service = new SeriesService();

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
                case 1 -> captureSeries();
                case 2 -> searchSeries();
                case 3 -> updateSeries();
                case 4 -> deleteSeries();
                case 5 -> viewReport();
                case 6 -> System.out.println("\nExiting Program. Goodbye!");
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void displayMenu() {
        System.out.println("====================================");
        System.out.println("     TV SERIES MANAGEMENT SYSTEM    ");
        System.out.println("====================================");
        System.out.println("1. Capture New Series");
        System.out.println("2. Search Series By ID");
        System.out.println("3. Update Series By ID");
        System.out.println("4. Delete Series By ID");
        System.out.println("5. View Series Report");
        System.out.println("6. Exit");
        System.out.println("====================================");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void captureSeries() {
        System.out.println("\n--- CAPTURE A NEW SERIES ---");
        System.out.print("Enter the series ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        int ageRestriction = getValidAgeRestriction();

        System.out.print("Enter the number of seasons: ");
        int seasons = getValidNumber();

        System.out.print("Enter the number of episodes: ");
        int episodes = getValidNumber();

        service.captureSeries(new SeriesModel(id, name, ageRestriction, seasons, episodes));
        System.out.println("\nSeries " + name + " captured successfully!\n");
    }

    private static void searchSeries() {
        System.out.print("\nEnter the series ID to search: ");
        String id = scanner.nextLine();
        SeriesModel series = service.searchSeries(id);

        if (series != null) {
            System.out.println("\n--- SERIES FOUND ---");
            System.out.println(series);
        } else {
            System.out.println("\nSeries not found.");
        }
    }

    private static void updateSeries() {
        System.out.print("\nEnter the series ID to update: ");
        String id = scanner.nextLine();

        System.out.print("Enter new series name: ");
        String newName = scanner.nextLine();

        int newAge = getValidAgeRestriction();

        System.out.print("Enter new number of episodes: ");
        int newEpisodes = getValidNumber();

        if (service.updateSeries(id, newName, newAge, newEpisodes)) {
            System.out.println("\nSeries updated successfully!");
        } else {
            System.out.println("\nSeries not found.");
        }
    }

    private static void deleteSeries() {
        System.out.print("\nEnter the series ID to delete: ");
        String id = scanner.nextLine();

        if (service.deleteSeries(id)) {
            System.out.println("\nSeries deleted successfully!");
        } else {
            System.out.println("\nSeries not found.");
        }
    }

    private static void viewReport() {
        System.out.println("\n========= SERIES REPORT =========");
        System.out.println(service.seriesReport());
    }

    private static int getValidAgeRestriction() {
        int age = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the series age restriction (2-18): ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 2 && age <= 18) {
                    valid = true;
                } else {
                    System.out.println("Invalid age restriction.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
        return age;
    }

    private static int getValidNumber() {
        int number = -1;
        boolean valid = false;
        while (!valid) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number >= 0) {
                    valid = true;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
        return number;
    }
}
