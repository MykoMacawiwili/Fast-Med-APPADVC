package com.csb.appadvcmidterms.controller;

import com.csb.appadvcmidterms.dto.UserDTO;
import com.csb.appadvcmidterms.dto.AppointmentDTO;
import com.csb.appadvcmidterms.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("Appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public String List(Model model) {
        model.addAttribute("Appointment", appointmentService.list());
        return "Appointment/List";
    }

    @GetMapping("/Reservation")
    private String getReserveForm(Model model) {
        model.addAttribute("Appointment", new AppointmentDTO());
        return "Appointment/Reservation";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("Appointment") AppointmentDTO appointmentDTO, BindingResult bindingResult, Model model ) {

        if(bindingResult.hasErrors()){
            model.addAttribute("Appointment", appointmentDTO);
            return "Appointment/Reservation";
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;

        if (principal instanceof UserDTO) {
            email = ((UserDTO) principal).getEmailAddress();
        } else {
            email = principal.toString();
        }

        appointmentDTO.setEmail(email);
        appointmentService.add(appointmentDTO);
        return List(model);
    }

    @GetMapping("/{id}")
    private String get(@PathVariable int id, Model model) {
        model.addAttribute("Appointment", appointmentService.get(id));
        return "Appointment/Edit";
    }

    @PutMapping
    private String update(AppointmentDTO appointment, Model model) {
        appointmentService.update(appointment);
        return List(model);
    }

    @DeleteMapping
    private String delete(AppointmentDTO appointment, Model model) {
        appointmentService.delete(appointment.getReserveId());
        return List(model);
    }
}

