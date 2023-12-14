package com.csb.appadvcmidterms.model;

import com.csb.appadvcmidterms.dto.AppointmentDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reserveId;

    @ManyToOne
    @JoinColumn(name = "email_address", nullable = false)
    private User email;

    @Column(nullable = false)
    private String reservee;

    @Column(nullable = false)
    private String doctor;

    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    @Column(nullable = false)
    private String inquiry;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    public Appointment() {}

    public Appointment(AppointmentDTO appointmentDTO) {
        this.reserveId = appointmentDTO.getReserveId();
        this.reservee = appointmentDTO.getReservee();
        this.doctor = appointmentDTO.getDoctor();
        this.date = appointmentDTO.getDate();
        this.inquiry = appointmentDTO.getInquiry();
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public User getEmail() { return email;}

    public void setEmail(User email) { this.email = email;}

    public String getReservee() {
        return reservee;
    }

    public void setReservee(String reservee) {
        this.reservee = reservee;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        inquiry = inquiry;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
