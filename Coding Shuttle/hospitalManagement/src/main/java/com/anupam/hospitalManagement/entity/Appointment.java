package com.anupam.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString // This annotation generates a toString() method for the class, which is useful for debugging and logging purposes. It provides a string representation of the object, including its fields and their values.
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @JoinColumn(nullable = false) // Patient is required. Owning side -> this side is dictating the foreign key column.
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY is used to avoid loading the doctor entity unless it is explicitly accessed. This can improve performance when fetching appointments without needing doctor details.
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
