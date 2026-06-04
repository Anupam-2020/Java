package com.anupam.module2.dto;

import com.anupam.module2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

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

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public EmployeeDTO(Long id, Boolean isActive, LocalDate dateOfJoining, Integer age, String email, String name, String role, Integer salary) {
        this.id = id;
        this.isActive = isActive;
        this.dateOfJoining = dateOfJoining;
        this.age = age;
        this.email = email;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public EmployeeDTO() {
    }

    private Long id;
    @Size(min = 3, max = 10, message = "number of chars between [3, 10")
    @NotBlank(message = "name can't be blank")
    private String name;

    @Email(message = "email should be valid")
    private String email;

    @Max(value = 80, message = "Age can't be > 80")
    @Min(value = 18, message = "Age >= 18")
    private Integer age;

//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee can be USER or ADMIN")
    @EmployeeRoleValidation
    @NotBlank(message = "Role can't be blank")
    private String role; // admin or user

    @NotNull(message = "Salary can't be null")
    @Positive(message = "Salary should be positive")
    private Integer salary;

    @PastOrPresent(message = "Date can't be future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employees should be true")
    @JsonProperty("isActive") // @JsonProperty is a Jackson annotation used to control how JSON fields are mapped to Java object fields during serialization and deserialization.
    private Boolean isActive;
}
