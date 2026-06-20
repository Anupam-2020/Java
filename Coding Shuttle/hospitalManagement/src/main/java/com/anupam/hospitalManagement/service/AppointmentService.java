package com.anupam.hospitalManagement.service;

import com.anupam.hospitalManagement.entity.Appointment;
import com.anupam.hospitalManagement.entity.Doctor;
import com.anupam.hospitalManagement.entity.Patient;
import com.anupam.hospitalManagement.repository.AppointmentRepository;
import com.anupam.hospitalManagement.repository.DoctorRepository;
import com.anupam.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new EntityNotFoundException("Doctor not found with id - "+doctorId));
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not be present in table");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); // to maintain bi-directional mapping.

        return appointmentRepository.save(appointment); // here we need to appointment, because this is first time appointment is getting added to the database,
        // if the appointment had to be updated then we need not write any query to update in db, while committing transaction the data will automatically get updated.
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); // this will automatically call the update, because it got dirty.
        doctor.getAppointments().add(appointment); // for bi-directional mapping.

        return appointment;
    }
}
