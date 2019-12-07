package com.example.springmaildemo.model;

import lombok.Data;

@Data
public class MailContent {

    private String to;
    private String subject;
    private String body;
}
