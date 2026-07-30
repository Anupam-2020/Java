package com.anupam.hospitalManagement.repository;

import com.anupam.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.anupam.hospitalManagement.entity.Patient;
import com.anupam.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    Patient findByDateOfBirth(LocalDate dob);
    List<Patient> findByDateOfBirthOrEmail(LocalDate birthDate, String email);

    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

//    @Query("SELECT p.bloodGroup, COUNT(p) FROM Patient p GROUP BY p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();

    @Query("SELECT new com.anupam.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, COUNT(p)) FROM Patient p GROUP BY p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "SELECT * FROM patients", nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional // @Transactional annotation is used to indicate that the method should be executed within a transaction. It ensures that the update operation is performed atomically and can be rolled back in case of any errors.
    @Modifying // @Modifying annotation is used to indicate that the query is an update or delete query. It is used in conjunction with @Query annotation.
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query(value = "SELECT * FROM Patients", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

    // for n+1 query problem. -> here we are using left join fetch to fetch the appointments and doctors along with the patients in a single query.
    // n + 1 problem occurs when we have a one-to-many or many-to-many relationship and we are fetching the parent entity and then for each parent entity we are fetching the child entities in a separate query.
    // This results in n+1 queries where n is the number of parent entities. To avoid this problem, we can use left join fetch to fetch the child entities along with the parent entities in a single query.
    // Alternate query for this ignoring n + 1 problem is "SELECT p FROM Patient p JOIN FETCH p.appointments a JOIN FETCH a.doctor" but this will not return patients without appointments. So we are using left join fetch to return all patients along with their appointments and doctors.
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor") // This query will return all patients along with their appointments and doctors. If a patient has no appointments, it will still return the patient with an empty list of appointments.
    List<Patient> findAllPatientWithAppointment();
}
