package com.anupam.module2.services;

import com.anupam.module2.dto.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public boolean isEmployeeExists(Long employeeId);

    public EmployeeDTO getEmployeeById(Long id);

    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO createNewEmployee(EmployeeDTO employee);

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employee);

    public EmployeeDTO deleteEmployee(Long employeeId);

    public EmployeeDTO updatePartialEmployee(Long employeeId, Map<String, Object> updates);
}
