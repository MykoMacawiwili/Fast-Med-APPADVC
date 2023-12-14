package com.csb.appadvcmidterms.repository;

import com.csb.appadvcmidterms.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}
