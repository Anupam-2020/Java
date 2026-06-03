package com.anupam.studentManagementJpa.repository;

import com.anupam.studentManagementJpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
