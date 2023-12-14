package com.csb.appadvcmidterms.services;

import com.csb.appadvcmidterms.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {

    List<DoctorDTO> list();

    void add(DoctorDTO doctor);

    DoctorDTO get(Integer id);

    void update(DoctorDTO doctor);

    void delete(Integer id);
}
