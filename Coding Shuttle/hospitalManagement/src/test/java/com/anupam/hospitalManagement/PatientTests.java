package com.anupam.hospitalManagement;

import com.anupam.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.anupam.hospitalManagement.entity.Patient;
import com.anupam.hospitalManagement.repository.PatientRepository;
import com.anupam.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @Test
    public void testPatients() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

        Patient p1 = new Patient();
        patientRepository.save(p1);
    }

    @Test
    public void addPatients() {
        List<Patient> patientList = new ArrayList<>(List.of(
                Patient.builder()
                        .name("Anupam")
                        .email("anupa@gmal.com")
                        .gender("Male")
                        .dateOfBirth(LocalDate.of(2020, 4, 12))
                        .build(),
                Patient.builder()
                        .name("Anupam2")
                        .email("anupam2@gmail.com").gender("Male")
                        .dateOfBirth(LocalDate.of(2020, 2, 12))
                        .build()
        ));

        Patient patients = new Patient();
        patients.setName("Anupama");
        patients.setEmail("anupama@gmail.com");
        patients.setGender("Male");
        patients.setDateOfBirth(LocalDate.of(2020, 12, 12));

        patientList.add(patients);

        List<Patient> patientLists = patientRepository.saveAll(patientList);
        System.out.println("email -> " + patientLists);
        System.out.println(patientLists.size());
    }

    @Test
    public void testTransactionMethods() {
//        Patient patient = patientService.getPatientById(1L);

//        Patient patient1 = patientRepository.findByName("Diya Patel");
//        List<Patient> patients = patientRepository.findByDateOfBirthOrEmail(LocalDate.of(1995, 8, 20), "dishant.verma@example.com");
//        List<Patient> patients = patientRepository.findByNameContainingOrderByIdDesc("Di");
//        List<Patient> patients = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        List<Patient> patients = patientRepository.findByBornAfterDate(LocalDate.of(1993, 3, 14));
//        List<Patient> patients = patientRepository.findAllPatients();
//
//        for(Patient patient: patients) {
//            System.out.println(patient);
//        }

        Page<Patient> patients = patientRepository.findAllPatients(PageRequest.of(1, 2, Sort.by("name").ascending()));
        for(Patient patient: patients) {
            System.out.println(patient);
        }

//        int rowsUpdated = patientRepository.updateNameWithId("Aarava Sharma", 1L);
//        System.out.println(rowsUpdated);

//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList) {
//            System.out.println(Arrays.toString(objects));
//        }

//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList) {
//            System.out.println(bloodGroupCountResponse);
//        }


    }

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }
}
