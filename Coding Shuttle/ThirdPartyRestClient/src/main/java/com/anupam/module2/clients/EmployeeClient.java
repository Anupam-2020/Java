package com.anupam.module2.clients;

import com.anupam.module2.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
