package com.anupam.module2.services.impl;

import com.anupam.module2.dto.EmployeeDTO;
import com.anupam.module2.entities.EmployeeEntity;
import com.anupam.module2.exception.ResourceNotFoundException;
import com.anupam.module2.repositories.EmployeeRepository;
import com.anupam.module2.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isEmployeeExists(Long employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        log.info("Fetching employee with id: {}", id);
        if(!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found");
        }
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);

//        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getActive(), employeeEntity.getDateOfJoining(), employeeEntity.getAge(), employeeEntity.getEmail(), employeeEntity.getName());
//        return employeeRepository.findById(id).orElse(null);
    }

    public List<EmployeeDTO> getEmployeesByEmail(String email) {
        log.info("Fetching employees with email: {}", email);

        List<EmployeeEntity> employeeEntities = employeeRepository.findByEmail(email);

        return employeeEntities
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employee) {
        EmployeeEntity toSaveEntity = modelMapper.map(employee, EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employee) {
        EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO deleteEmployee(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        employeeRepository.deleteById(employeeId);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    //Reflection is a Java feature that allows you to :-
    //Inspect classes at runtime
    //Access private fields and methods
    //Modify object properties dynamically
    //Create objects dynamically
    //ReflectionUtils is a Spring utility built on Java Reflection. It allows fields of an object to be located and modified dynamically at runtime

    @Override
    public EmployeeDTO updatePartialEmployee(Long employeeId, Map<String, Object> updates) {
        boolean exists = isEmployeeExists(employeeId);
        if(!exists) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((key, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(EmployeeEntity.class, key); // here that particular field is returned.
            fieldToBeUpdated.setAccessible(true); // Since fields are private, so, Java won't allow accessing it,
            // so we need to make setAccessible to true,
            // which bypasses that check.

            if(fieldToBeUpdated.getType().equals(LocalDate.class)) { // Need to manually handle for LocalDate class.
                LocalDate date = LocalDate.parse(value.toString());
                if(date.isAfter(LocalDate.now())) {
                    throw new IllegalArgumentException(
                            "Date of joining cannot be in future");
                }
                value = LocalDate.parse(value.toString());
            }
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value); // now after bypassing the check, we can now inject the updated value to the required field.
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
