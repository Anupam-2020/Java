package com.anupam.studentManagementJpa.repository;

import com.anupam.studentManagementJpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    Optional<Student> findByEmail(String email);

    List<Student> findByAgeGreaterThan(int age);

    List<Student> findByAgeLessThan(int age);

    List<Student> findByNameContaining(String keyword);

    List<Student> findByNameAndAge(String name, int age);

    List<Student> findByNameOrEmail(String name, String email);

    List<Student> findByAgeBetween(int min, int max);

    @Query("SELECT s FROM Student s WHERE s.age > :age")
    List<Student> findStudentsOlderThan(@Param("age") int age);

    @Query("""
            SELECT s FROM Student s WHERE s.department.name = :departmentName
            """)
    List<Student> findStudentByDepartmentName(@Param("department") String department);

    Page<Student> findByAgeGreaterThan(int age, Pageable pageable);
}
