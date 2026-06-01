package com.anand.studentManagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Student {
    Integer id;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    String email;

    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "name should be of at least 2 chars")
    String name;

    @NotBlank(message = "course should not be empty")
    String course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public Student(Integer id, String email, String name, String course) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.course = course;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student() {

    }
}
