package org.example;

import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

//Created by: Christopher Rossi


public class AppointmentTest {

    @Test
    public void testAppointmentConstructorValid() {
        Appointment appointment = new Appointment("A12345", new Date(System.currentTimeMillis() + 10000), "Meeting with client");
        assertNotNull(appointment);
        assertEquals("A12345", appointment.getAppointmentId());
        assertNotNull(appointment.getAppointmentDate());
        assertEquals("Meeting with client", appointment.getDescription());
    }

    @Test
    public void testAppointmentIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345678901", new Date(System.currentTimeMillis() + 10000), "Long description");
        });
    }

    @Test
    public void testAppointmentDateInThePast() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", new Date(System.currentTimeMillis() - 10000), "Past appointment");
        });
    }

    @Test
    public void testAppointmentDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", new Date(System.currentTimeMillis() + 10000), "This is a very long description that exceeds fifty characters.");
        });
    }
}