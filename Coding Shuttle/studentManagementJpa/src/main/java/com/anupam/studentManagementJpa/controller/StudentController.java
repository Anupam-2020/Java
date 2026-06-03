package com.anupam.studentManagementJpa.controller;

import com.anupam.studentManagementJpa.entity.Student;
import com.anupam.studentManagementJpa.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/name")
    public List<Student> getStudentsByName(@RequestParam String name) {
        return studentService.getStudentsByName(name);
    }

    @GetMapping("/age-greater-than")
    public List<Student> getStudentAboveAge(@RequestParam int age) {
        return studentService.getStudentAboveAge(age);
    }

    @GetMapping("/search")
    public List<Student> searchStudentByName(@RequestParam String name) {
        return studentService.searchStudentsByName(name);
    }

    @GetMapping("/age-between")
    public List<Student> getStudentsBetweenAge(@RequestParam int minAge, @RequestParam int maxAge) {
        return studentService.getStudentsBetweenAge(minAge, maxAge);
    }

    @GetMapping("/department")
    public List<Student> getStudentByDepartment(@RequestParam String departmentName) {
        return studentService.getStudentsByDepartment(departmentName);
    }

    @GetMapping("/page")
    public Page<Student> getStudentWithPagination(@RequestParam int page, @RequestParam int size) {
        return studentService.getStudentWithPagination(page, size);
    }

    @GetMapping("/sort")
    public List<Student> getStudentsWithSorting() {
        return studentService.getStudentsWithSorting();
    }

    @GetMapping("/age-page-sort")
    public Page<Student> getStudentsAboveAgeWithPagination(
            @RequestParam int age,
            @RequestParam int page,
            @RequestParam int size
    ) {
        return studentService.getStudentsAboveAgeWithPagination(age, page, size);
    }
}
