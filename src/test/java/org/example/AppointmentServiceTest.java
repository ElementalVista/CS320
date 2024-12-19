package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

//Created by: Christopher Rossi



public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("A12345", new Date(System.currentTimeMillis() + 10000), "Doctor's appointment");
        assertTrue(appointmentService.addAppointment(appointment));
        assertNotNull(appointmentService.getAppointment("A12345"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("A12345", new Date(System.currentTimeMillis() + 10000), "Doctor's appointment");
        appointmentService.addAppointment(appointment1);

        Appointment appointment2 = new Appointment("A12345", new Date(System.currentTimeMillis() + 20000), "Dentist appointment");
        assertFalse(appointmentService.addAppointment(appointment2)); // Duplicate ID
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("A12345", new Date(System.currentTimeMillis() + 10000), "Doctor's appointment");
        appointmentService.addAppointment(appointment);
        assertTrue(appointmentService.deleteAppointment("A12345"));
        assertNull(appointmentService.getAppointment("A12345"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertFalse(appointmentService.deleteAppointment("A99999")); // Non-existent appointment
    }
}