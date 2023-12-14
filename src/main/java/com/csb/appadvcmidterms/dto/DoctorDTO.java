package com.csb.appadvcmidterms.dto;

import com.csb.appadvcmidterms.model.Doctor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class DoctorDTO {
    private Integer id;

    @NotBlank(message = "FirstName is Required!")
    private String firstName;

    @NotBlank(message = "LastName is Required!")
    private String lastName;

    @NotBlank(message = "EmailAddress is Required!")
    @Email(message = "EmailAddress format is not valid!")
    private String emailAddress;

    @NotBlank(message = "Specialization is Required!")
    private String specialization;

    public DoctorDTO() {}

    public DoctorDTO(Integer id, String firstName, String lastName, String emailAddress, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.specialization = specialization;
    }

    public DoctorDTO (Doctor doctor) {
        this.id = doctor.getId();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.emailAddress = doctor.getEmailAddress();
        this.specialization = doctor.getSpecialization();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
