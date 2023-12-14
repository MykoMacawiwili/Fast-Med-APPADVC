package com.csb.appadvcmidterms.dto;

import com.csb.appadvcmidterms.model.Appointment;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AppointmentDTO {
    private Integer reserveId;

    private String email;

    @NotBlank(message = "Name is Required!")
    private String reservee;

    @NotBlank(message = "Doctor Specialty is Required!")
    private String doctor;

    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @NotNull(message = "Doctor Specialty is Required!")
    @Future(message = "Cannot be a past or present time/date!")
    private LocalDateTime date;

    @NotBlank(message = "Inquiry is required")
    private String inquiry;

    public AppointmentDTO() {}

    public AppointmentDTO(Integer reserveid, String email, String reservee, String doctor, LocalDateTime date, String inquiry) {
        this.reserveId = reserveid;
        this.email = email;
        this.reservee = reservee;
        this.doctor = doctor;
        this.date = date;
        this.inquiry = inquiry;
    }

    public AppointmentDTO (Appointment appointment) {
        this.reserveId = appointment.getReserveId();
        this.email = appointment.getEmail().getEmailAddress();
        this.reservee = appointment.getReservee();
        this.doctor = appointment.getDoctor();
        this.date = appointment.getDate();
        this.inquiry = appointment.getInquiry();
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public String getReservee() {
        return reservee;
    }

    public String getEmail() { return email;}

    public void setEmail(String email) { this.email = email;}

    public void setReservee(String reservee) {
        this.reservee = reservee;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDate() { return date;}

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }
}
