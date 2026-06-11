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

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "patient_insurance_id") // owning side
    private Insurance insurance;
    
    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Appointment> appointments;
}
