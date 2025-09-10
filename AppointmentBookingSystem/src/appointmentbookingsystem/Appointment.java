/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointmentbookingsystem;

/**
 *
 * @author Thabang Mathuloe
 */
public class Appointment {
    private final String customerName;
    private boolean booked;

    public Appointment(String customerName) {
        this.customerName = customerName;
        this.booked = true; // default booked
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean isBooked() {
        return booked;
    }

    public void cancel() {
        this.booked = false;
    }

    @Override
    public String toString() {
        return "Appointment with " + customerName + " | Status: " + (booked ? "Booked" : "Cancelled");
    }
}
