package com.anupam.hospitalManagement.service;

import com.anupam.hospitalManagement.entity.Insurance;
import com.anupam.hospitalManagement.entity.Patient;
import com.anupam.hospitalManagement.repository.InsuranceRepository;
import com.anupam.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+ patientId));
        patient.setInsurance(insurance);

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // for bidirectional maintenance

        return patient;
    }
}
