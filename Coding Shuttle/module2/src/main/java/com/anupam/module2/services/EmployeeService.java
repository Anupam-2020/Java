package com.anupam.module2.services;

import com.anupam.module2.dto.EmployeeDTO;
import com.anupam.module2.entities.EmployeeEntity;
import com.anupam.module2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public boolean isEmployeeExists(Long employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    public EmployeeDTO getEmployeeId(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);

//        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getActive(), employeeEntity.getDateOfJoining(), employeeEntity.getAge(), employeeEntity.getEmail(), employeeEntity.getName());
//        return employeeRepository.findById(id).orElse(null);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employee) {
        EmployeeEntity toSaveEntity = modelMapper.map(employee, EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employee) {
        EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO deleteEmployee(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        employeeRepository.deleteById(employeeId);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updatePartialEmployee(Long employeeId, Map<String, Object> updates) {
        boolean exists = isEmployeeExists(employeeId);
        if(!exists) return  null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((key, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(EmployeeEntity.class, key);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
