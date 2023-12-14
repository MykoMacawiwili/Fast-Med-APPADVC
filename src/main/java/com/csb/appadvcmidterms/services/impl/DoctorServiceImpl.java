package com.csb.appadvcmidterms.services.impl;

import com.csb.appadvcmidterms.dto.DoctorDTO;
import com.csb.appadvcmidterms.model.Doctor;
import com.csb.appadvcmidterms.repository.DoctorRepository;
import com.csb.appadvcmidterms.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<DoctorDTO> list() {
        return StreamSupport.stream(doctorRepository.findAll().spliterator(), false)
                .map(DoctorDTO :: new)
                .collect(Collectors.toList());
    }
    @Override
    public void add(DoctorDTO doctor) {doctorRepository.save(new Doctor(doctor));}

    @Override
    public DoctorDTO get(Integer id) {
        return new DoctorDTO(doctorRepository.findById(id).get());
    }

    @Override
    public void update(DoctorDTO updatedDoctor) {
        doctorRepository.save(new Doctor(updatedDoctor));
    }

    @Override
    public void delete(Integer id) {
        doctorRepository.deleteById(id);
    }


}
