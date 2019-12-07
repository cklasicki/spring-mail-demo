package com.example.springmaildemo;

import com.example.springmaildemo.model.MailContent;
import com.example.springmaildemo.services.EmailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class IndexController {

    private final EmailService emailService;

    public IndexController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String index(MailContent mailContent) {
        return "index";
    }

    @PostMapping(value = "sendMail")
    public String index(MailContent mailContent, Model model) {
        emailService.sendEmail(mailContent.getTo(), mailContent.getSubject(), mailContent.getBody());
        String status = "OK";
        model.addAttribute("status", status);
        log.info(mailContent);
        return "confirmation";
    }
}
