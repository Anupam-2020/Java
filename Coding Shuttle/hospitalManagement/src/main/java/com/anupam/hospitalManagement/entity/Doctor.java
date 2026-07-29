package com.anupam.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @ManyToMany(mappedBy = "doctors") // inverse side -> this side is not dictating the foreign key column.
    private Set<Department> departments = new HashSet<>();

    @OneToMany(mappedBy = "doctor") // inverse side -> this side is not dictating the foreign key column.
    private List<Appointment> appointments = new ArrayList<>();
}
