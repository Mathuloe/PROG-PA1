/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
/**
 *
 * @author Thabang Mathuloe
 */
import appointmentbookingsystem.Appointment;
import appointmentbookingsystem.Consultation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

    @Test
    public void testAppointmentIsBookedByDefault() {
        Appointment a = new Appointment("John");
        assertTrue(a.isBooked());
    }

    @Test
    public void testCancelAppointment() {
        Appointment a = new Appointment("John");
        a.cancel();
        assertFalse(a.isBooked());
    }

    @Test
    public void testConsultationSubclass() {
        Consultation c = new Consultation("Alice", "Skin Care");
        assertTrue(c.isBooked());
        assertEquals("Skin Care", c.getTopic());
    }
}

