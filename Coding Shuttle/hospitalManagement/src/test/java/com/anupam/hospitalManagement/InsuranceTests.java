package com.anupam.hospitalManagement;

import com.anupam.hospitalManagement.entity.Appointment;
import com.anupam.hospitalManagement.entity.Insurance;
import com.anupam.hospitalManagement.entity.Patient;
import com.anupam.hospitalManagement.service.AppointmentService;
import com.anupam.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12,21))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);

        Patient newPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);
    }

    @Test
    public void testAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(
                        LocalDateTime.of(2026, 11, 1, 12, 23, 1))
                .reason("Cancer")
                .build();

        Appointment newAppointment = appointmentService.createNewAppointment(appointment, 2L, 1L);
        System.out.println(newAppointment);

        Appointment updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);
        System.out.println(updatedAppointment);
    }
}
