/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appointmentbookingsystem;

/**
 *
 * @author Thabang Mathuloe
 */
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentBookingSystem {
    private static final ArrayList<Appointment> appointments = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Appointment Booking System ===");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addAppointment();
                case 2 -> viewAppointments();
                case 3 -> cancelAppointment();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }

    private static void addAppointment() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Is this a consultation? (yes/no): ");
        String isConsultation = scanner.nextLine();

        if (isConsultation.equalsIgnoreCase("yes")) {
            System.out.print("Enter consultation topic: ");
            String topic = scanner.nextLine();
            appointments.add(new Consultation(name, topic));
        } else {
            appointments.add(new Appointment(name));
        }
        System.out.println("Appointment added successfully.");
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked.");
        } else {
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println((i + 1) + ". " + appointments.get(i));
            }
        }
    }

    private static void cancelAppointment() {
        viewAppointments();
        if (!appointments.isEmpty()) {
            System.out.print("Enter appointment number to cancel: ");
            int number = Integer.parseInt(scanner.nextLine());
            if (number > 0 && number <= appointments.size()) {
                appointments.get(number - 1).cancel();
                System.out.println("Appointment cancelled.");
            } else {
                System.out.println("Invalid appointment number.");
            }
        }
    }
}