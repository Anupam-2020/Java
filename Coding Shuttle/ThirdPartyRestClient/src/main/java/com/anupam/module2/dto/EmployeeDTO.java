package com.anupam.module2.dto;

import com.anupam.module2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

// DTO -> Data Transfer Object. Spring Boot uses it specifically to separate database models (Entities) from the public API layer(Controllers).
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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
