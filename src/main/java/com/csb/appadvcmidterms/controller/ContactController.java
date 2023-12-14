package com.csb.appadvcmidterms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String showContactForm(){

        return "user/FeedbackForm";
    }
    @PostMapping("/contact")
    public String submitContact(HttpServletRequest request) {
        String fullname = request.getParameter("FullName");
        String email = request.getParameter("Email");
        String subject = request.getParameter("Subject");
        String content = request.getParameter("Content");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("appadvc123@gmail.com");
        message.setTo("jerichoruiz26@gmail.com");

        String mailSubject = fullname + " has sent a feedback";
        String mailContent = "Sender Name: " + fullname + "\n";
        mailContent += "Sender E-mail: " + email + "\n";
        mailContent += "Subject:  " + subject + "\n";
        mailContent += "Content: " + content + "\n";

        message.setSubject(mailSubject);
        message.setText(mailContent);

        mailSender.send(message);

        return "FeedbackMessage";
    }
}

