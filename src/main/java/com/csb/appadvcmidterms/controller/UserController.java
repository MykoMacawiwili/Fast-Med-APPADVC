package com.csb.appadvcmidterms.controller;


import com.csb.appadvcmidterms.dto.AppointmentDTO;
import com.csb.appadvcmidterms.dto.UserDTO;
import com.csb.appadvcmidterms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    private static final String USER_ROLE = "USER_CUSTOMER";

    @Autowired
    private UserService userService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("user", userService.list());
        return "user/userlist";
    }

    @GetMapping("/add")
    public String userAdd(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/SignUp";
    }

    @GetMapping("/{id}")
    private String getUser(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.get(id));
        return "user/viewlist";
    }

    @PutMapping
    private String updateUser(UserDTO user, Model model){

        userService.update(user);
        model.addAttribute("user", userService.list());
        return list(model);
    }

    @DeleteMapping
    private String deleteUser(UserDTO user, Model model){
        userService.delete(user.getId());
        return list(model);
    }
}
