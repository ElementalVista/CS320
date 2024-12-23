
package org.example;
import java.util.Date;

//Created by: Christopher Rossi

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    // Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must be non-null and no longer than 10 characters.");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment Date cannot be null or in the past.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null and must be no longer than 50 characters.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}