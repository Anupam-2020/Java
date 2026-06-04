package com.anupam.module2.controllers;


import com.anupam.module2.dto.EmployeeDTO;
import com.anupam.module2.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// @ResponseBody ->The @ResponseBody annotation tells a Spring controller that the object returned from a method should be serialized directly into the HTTP response body, rather than looking for an HTML view or template.
// It tells Spring to hand the returned Java object to a message converter—like Jackson—to transform it into JSON or XML and send it straight back to the client.

// The `@ComponentScan` annotation in the Spring framework automatically looks through specified Java packages to find classes marked with annotations like @Component, @Service, @Repository, and @Controller.
// It tells Spring to convert these classes into managed "beans" and wire them together, eliminating the need to declare them manually.

// Jackson is a Java library used primarily for translating Java objects into JSON data and vice versa.
// In Spring Boot, it is the default, built-in engine that automatically handles serializing (converting Java to JSON) and deserializing (converting JSON to Java) data behind the scenes in your REST APIs.
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @GetMapping(path = "/getMessage")
    public String getMyMessage() {
        return "Secret Message";
    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeId(@PathVariable(name = "employeeId") Long id) {
//        return new EmployeeDTO(employeeId, true, LocalDate.of(2026, 1, 2), 26, "@anupam@gmail.com", "Anupam");
        return ResponseEntity.ok(employeeService.getEmployeeId(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age, @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        return new ResponseEntity<>(employeeService.createNewEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employee, @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employee));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@RequestBody @Valid Map<String, Object> updates, @PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployee(employeeId, updates);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
