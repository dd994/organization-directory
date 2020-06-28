package com.gmail.ddzhunenko.organizationdirectory.entity;

import javax.persistence.Entity;
import java.util.List;

public class Employee {

    private String login;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String birthday;
    private String photo;
    private List<String> phone;
    private List<String> mail;
    private String codePosition;

    public Employee() {
    }

}
