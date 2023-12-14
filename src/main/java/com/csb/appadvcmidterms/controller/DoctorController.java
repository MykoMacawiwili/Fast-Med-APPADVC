package com.csb.appadvcmidterms.controller;

import com.csb.appadvcmidterms.dto.DoctorDTO;
import com.csb.appadvcmidterms.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("doctor", doctorService.list());
        return "doctor/Doctorlist";
    }

    @GetMapping("/doctorAdd")
    private String getDoctorForm(Model model) {
        model.addAttribute("doctor", new DoctorDTO());
        return "doctor/DoctorAdd";
    }

    @PostMapping
    private String addDoctor(@Valid @ModelAttribute("doctor") DoctorDTO doctor, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("doctor", doctor);
            return "doctor/DoctorAdd";
        }
        doctorService.add(doctor);
        return list(model);
    }

    @GetMapping("/{id}")
    private String getDoctor(@PathVariable Integer id, Model model){
        model.addAttribute("doctor", doctorService.get(id));
        return "doctor/DoctorEdit";
    }

    @PutMapping
    private String updateDoctor(@Valid @ModelAttribute("doctor") DoctorDTO doctor, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("doctor", doctor);
            return "doctor/DoctorEdit";
        }
        doctorService.update(doctor);
        return list(model);
    }

    @DeleteMapping
    private String deleteDoctor(DoctorDTO doctor, Model model){
        doctorService.delete(doctor.getId());
        return list(model);
    }
}
