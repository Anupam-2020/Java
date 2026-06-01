package com.anand.EmployeeAPI.components;

import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {
    public boolean isValidDepartment(String department) {
        return department != null && !department.isEmpty();
    }
}
