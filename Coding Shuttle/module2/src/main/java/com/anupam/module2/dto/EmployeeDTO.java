package com.anupam.module2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

// DTO -> Data Transfer Object. Spring Boot uses it specifically to separate database models (Entities) from the public API layer(Controllers).
public class EmployeeDTO {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public EmployeeDTO(Long id, Boolean isActive, String dateOfJoining, Integer age, String email, String name) {
        this.id = id;
        this.isActive = isActive;
        this.dateOfJoining = dateOfJoining;
        this.age = age;
        this.email = email;
        this.name = name;
    }

    public EmployeeDTO() {
    }

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;
}
