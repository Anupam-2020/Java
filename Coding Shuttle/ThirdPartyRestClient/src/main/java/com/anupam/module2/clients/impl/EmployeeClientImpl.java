package com.anupam.module2.clients.impl;

import com.anupam.module2.advices.ApiResponse;
import com.anupam.module2.clients.EmployeeClient;
import com.anupam.module2.dto.EmployeeDTO;
import com.anupam.module2.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOList.getData();
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
       try {
           ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.get()
                   .uri("employees/{employeeId}", employeeId)
                   .retrieve()
                   .body(new ParameterizedTypeReference<>() {
                   });

           return employeeDTOApiResponse.getData();
       } catch (Exception ex) {
           throw new RuntimeException(ex);
       }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        try {
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeResponse = restClient.post()
                    .uri("/employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, resp) -> {
                        System.out.println("Error occurred" + new String(resp.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not create the employee");
                    })
                    .toEntity(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {
                    });
            return employeeResponse.getBody().getData();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
