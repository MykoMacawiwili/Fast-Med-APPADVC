package com.csb.appadvcmidterms.services.impl;

import com.csb.appadvcmidterms.dto.AppointmentDTO;
import com.csb.appadvcmidterms.model.Appointment;
import com.csb.appadvcmidterms.model.User;
import com.csb.appadvcmidterms.repository.AppointmentRepository;
import com.csb.appadvcmidterms.repository.UserRepository;
import com.csb.appadvcmidterms.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppointmentDTO> list() {
        return StreamSupport.stream(appointmentRepository.findAll().spliterator(), false)
                .map(AppointmentDTO:: new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(AppointmentDTO appointmentDTO) {
        Appointment app = new Appointment(appointmentDTO);
        app.setEmail(userRepository.findByEmailAddress(appointmentDTO.getEmail()));
        appointmentRepository.save(app);
    }

    @Override
    public AppointmentDTO get(Integer id) { return new AppointmentDTO(appointmentRepository.findById(id).get());
    }

    @Override
    public void update(AppointmentDTO updatedAppointment) {

        Appointment appointment = new Appointment(updatedAppointment);
        User user = userRepository.findByEmailAddress(updatedAppointment.getEmail());
        appointment.setEmail(user);

        appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
