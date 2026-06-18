package com.anupam.module2;

import com.anupam.module2.clients.EmployeeClient;
import com.anupam.module2.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdReadyFeaturesApplicationTests {

    @Autowired
    private EmployeeClient employeeClient;

    @Test
    @Order(3)
    void getAllEmployees() {
        List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
        System.out.println(employeeDTOList);
    }

    @Test
    @Order(2)
    void getEmployeeById() {
        EmployeeDTO employeeDTO = employeeClient.getEmployeeById(1L);
        System.out.println(employeeDTO);
    }

    @Test
    @Order(1)
    void createNewEmployeeTest() {
        EmployeeDTO savedEmployeeDto = new EmployeeDTO(null, "Anupam", "anupam@gmail.com", 11, "USER", 5000, LocalDate.of(2020, 12, 1), true);
        EmployeeDTO employeeDTO = employeeClient.createNewEmployee(savedEmployeeDto);
        System.out.println(employeeDTO);
    }
}
