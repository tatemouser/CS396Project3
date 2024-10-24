// src/main/models/Patient.java
package main.models;

import java.time.LocalDateTime;
import main.healthcare.security.SecurityManager;

public class Patient {
    private String patientId;
    private String name;
    private String dateOfBirth;
    private String medicalHistory;
    private LocalDateTime lastUpdated;

    public Patient(String patientId, String name, String dateOfBirth) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.lastUpdated = LocalDateTime.now();
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.lastUpdated = LocalDateTime.now();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMedicalHistory() {
        // Encrypt sensitive data before returning
        return SecurityManager.getInstance().encryptSensitiveData(medicalHistory);
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
        this.lastUpdated = LocalDateTime.now();
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}