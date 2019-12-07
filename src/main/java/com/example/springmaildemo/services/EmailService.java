package com.example.springmaildemo.services;

public interface EmailService {

    void sendEmail(String to, String subject, String body);
}
