package com.anupam.module2.repositories;

import com.anupam.module2.TestContainerConfig;
import com.anupam.module2.dto.EmployeeDTO;
import com.anupam.module2.entities.EmployeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


//@SpringBootTest
@Import(TestContainerConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeEntity employeeEntity;

    @BeforeEach
    void setUp() {
        employeeEntity = EmployeeEntity.builder()
                .age(23)
                .email("anupam@gmail.com")
                .name("Anupam")
                .salary(123004)
                .role("Manager")
                .build();
    }

    @Test
    void testFindByEmail_whenEmailIsValid_thenReturnEmployee() {
        // Arrange, given
        employeeRepository.save(employeeEntity);

        // Act, When
        List<EmployeeEntity> employeeList = employeeRepository.findByEmail(employeeEntity.getEmail());

        // Assert, Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employeeEntity.getEmail());
    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmployeeList() {
        // Given
        String email = "notPresent@gmail.com";

        // When
        List<EmployeeEntity> employeeList = employeeRepository.findByEmail(email);

        // Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();
    }
}