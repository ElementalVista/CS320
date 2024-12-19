package org.example;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointments;

    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // Add a new appointment
    public boolean addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            return false; // Appointment ID must be unique
        }
        appointments.put(appointment.getAppointmentId(), appointment);
        return true;
    }

    // Delete an appointment by ID
    public boolean deleteAppointment(String appointmentId) {
        if (appointments.containsKey(appointmentId)) {
            appointments.remove(appointmentId);
            return true;
        }
        return false; // No appointment found with this ID
    }

    // Optional: Get appointment by ID (for testing)
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}