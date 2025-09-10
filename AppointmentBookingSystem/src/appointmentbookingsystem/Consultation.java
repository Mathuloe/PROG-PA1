/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointmentbookingsystem;

/**
 *
 * @author Thabang Mathuloe
 */
public class Consultation extends Appointment {
    private final String topic;

    public Consultation(String customerName, String topic) {
        super(customerName);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "Consultation with " + getCustomerName() + " about " + topic +
               " | Status: " + (isBooked() ? "Booked" : "Cancelled");
    }
}
