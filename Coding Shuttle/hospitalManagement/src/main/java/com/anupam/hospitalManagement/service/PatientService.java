package com.anupam.hospitalManagement.service;


import com.anupam.hospitalManagement.entity.Patient;
import com.anupam.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Patient getPatientById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 = patientRepository.findById(id).orElseThrow();

        p1.setName("Yoyo");

        System.out.println(p1 == p2);

        return p1;
    }
}
