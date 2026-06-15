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
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+ patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // for bidirectional maintenance ->
        // meaning The database will still be updated correctly even if we ignore this line because Patient is the owning side,
        // but the Java objects in-memory don't accurately reflect the relationship.

        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("No patient found with id"+patientId));
        patient.setInsurance(null);

        return patient;
    }
}
