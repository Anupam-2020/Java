package com.anupam.hospitalManagement.entity;

import com.anupam.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "patients", uniqueConstraints = {
        @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
        @UniqueConstraint(name = "unique_patient_name_date_of_birth", columnNames = {"name", "dateOfBirth"})
}, indexes = {
        @Index(name = "idx_patient_date_of_birth", columnList = "dateOfBirth, email")
})
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this is the default strategy for MySQL.
    // For Postgres, the default strategy is SEQUENCE.
    // For Oracle, the default strategy is SEQUENCE.
    // For SQL Server, the default strategy is IDENTITY.
    // IDENTITY means that the database will automatically generate a unique value for this column when a new record is inserted.
    // SEQUENCE means that a separate database sequence will be used to generate unique values for this column.
    // TABLE means that a separate table will be used to generate unique values for this column.
    private Long id;

//    @Column(name = "patient_name", nullable = false, length = 40)
    private String name;

//    @Column(unique = true)
    @Column(nullable = false)
    private String email;
    private String gender;

    @ToString.Exclude
    private LocalDate dateOfBirth;

    @CreationTimestamp
    @Column(updatable = false) // this is byDefault.
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true) // orphanRemoval = true -. means if we want to remove insurance but don't want to delete patient.
    // If we wanted to delete patient then we could use CascadeType.REMOVE
    @JoinColumn(name = "patient_insurance_id") // owning side -> this side is dictating the foreign key column, and the name of the foreign key column is patient_insurance_id.
    // unique is by default true because it is one to one mapping.
    private Insurance insurance;
    
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER) // inverse side -> this side is not dictating the foreign key column.
    @ToString.Exclude
    private List<Appointment> appointments;
}

// Note for orphanRemoval:-
// It is triggered -
//         1. For oneToMany:- When an entity is removed from the collection.
//         2. For OneToOne:- When the reference(Insurance) is set to null or replaced with new entity.
//         3. Orphaned entities are deleted automatically during JPA flush or when commit operation, without needing explicit calls to entity.remove();

// Difference b/w CascadeType.REMOVE and orphanRemoval = true:
//         1. CascadeType.REMOVE deletes the child element only when the parent is deleted.
//         2. orphanRemoval = true deletes child element when they are no longer referenced ny the parent element, even if parent remains in database.