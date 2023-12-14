package com.csb.appadvcmidterms.controller;

import com.csb.appadvcmidterms.dto.UserDTO;
import com.csb.appadvcmidterms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("SignUp")
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String SignUp(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/SignUp";
    }

    @PostMapping
    private String register(UserDTO userDTO, Model model) {
        userDTO.setRole("ROLE_USER");
        userService.add(userDTO);
        return "redirect:/Login";
    }

}
