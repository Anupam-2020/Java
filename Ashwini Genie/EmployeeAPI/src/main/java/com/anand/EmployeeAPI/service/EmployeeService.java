package com.anand.EmployeeAPI.service;

import com.anand.EmployeeAPI.components.EmployeeValidator;
import com.anand.EmployeeAPI.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeValidator employeeValidator;

    private final List<Employee> employees = List.of(
            new Employee(1, "Anand", "IT", 50000),
            new Employee(2, "Rahul", "HR", 55000)
    );

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeesById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        if(!employeeValidator.isValidDepartment(department)) return List.of();

        return employees.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
}
