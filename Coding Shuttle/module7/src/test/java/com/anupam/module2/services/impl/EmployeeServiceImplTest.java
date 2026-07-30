package com.anupam.module2.services.impl;

import com.anupam.module2.TestContainerConfig;
import com.anupam.module2.dto.EmployeeDTO;
import com.anupam.module2.entities.EmployeeEntity;
import com.anupam.module2.repositories.EmployeeRepository;
import com.anupam.module2.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestContainerConfig.class)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

//    @Mock
    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private EmployeeEntity mockEmployee;
    private EmployeeDTO mockEmployeeDTO;

    @BeforeEach
    void setUp() {
        mockEmployee = EmployeeEntity.builder()
                .id(1L)
                .email("anupam@gmail.com")
                .name("Anupam")
                .salary(200000)
                .age(23)
                .role("Manager")
                .build();

        mockEmployeeDTO = modelMapper.map(mockEmployee, EmployeeDTO.class);
    }

    @Test
    void testGetEmployeeId_WhenEmployeeIdPresent_ThenReturnEmployeeDto() {
//        employeeService.getEmployeeId(1L);

        // assign
        Long id = 1L;

        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockEmployee)); // stubbing

        // act
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);


        // assert
        assertThat(employeeDTO).isNotNull();
        assertThat(employeeDTO.getId()).isEqualTo(id);
        assertThat(employeeDTO.getEmail()).isEqualTo(mockEmployee.getEmail());
        verify(employeeRepository).findById(id);
    }

    @Test
    void testCreateNewEmployee_WhenValidEmployee_ThenCreateNewEmployee() {
        // assign
        when(employeeRepository.findByEmail(anyString())).thenReturn(List.of());
        when(employeeRepository.save(any(EmployeeEntity.class))).thenReturn(mockEmployee);

        // act
        EmployeeDTO employeeDTO = employeeService.createNewEmployee(mockEmployeeDTO);

        // assert
        assertThat(employeeDTO).isNotNull();
        assertThat(employeeDTO.getEmail()).isEqualTo(mockEmployeeDTO.getEmail());
        verify(employeeRepository.save(any()));
    }
}