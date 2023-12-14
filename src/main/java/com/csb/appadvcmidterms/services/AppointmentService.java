package com.csb.appadvcmidterms.services;

import com.csb.appadvcmidterms.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    List<AppointmentDTO> list();

    void add(AppointmentDTO doctor);

    AppointmentDTO get(Integer id);

    void update(AppointmentDTO doctor);

    void delete(Integer id);
}
