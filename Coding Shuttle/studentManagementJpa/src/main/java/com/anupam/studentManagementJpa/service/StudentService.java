package com.anupam.studentManagementJpa.service;

import com.anupam.studentManagementJpa.entity.Student;
import com.anupam.studentManagementJpa.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentAboveAge(int age) {
        return studentRepository.findByAgeGreaterThan(age);
    }

    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContaining(name);
    }

    public List<Student> getStudentsBetweenAge(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public List<Student> getStudentsByDepartment(String departmentName) {
        return studentRepository.findStudentByDepartmentName(departmentName);
    }

    public Page<Student> getStudentWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable);
    }

    public List<Student> getStudentsWithSorting() {
        return studentRepository.findAll(
                Sort.by("age").descending()
        );
    }

    public Page<Student> getStudentsAboveAgeWithPagination(int age, int page, int size) {
        Pageable pageable = PageRequest.of(
                page, size, Sort.by("name").ascending()
        );

        return studentRepository.findByAgeGreaterThan(age, pageable);
    }
}
