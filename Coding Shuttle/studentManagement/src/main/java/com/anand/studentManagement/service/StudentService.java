package com.anand.studentManagement.service;

import com.anand.studentManagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    private int nextId = 3;

    public List<Student> getAllStudents(String name) {
        if(name == null) {
            return students;
        }

        return students.stream().filter(student -> student.getName().
                equalsIgnoreCase(name)).
                toList();
    }

    public Student getStudentById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().get();
    }

    public Student addStudent(Student student) {
        if(student == null) return null;
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    public Student updateStudent(Student student, int id) {
        if(student == null) return null;
        Student existingStudent = getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setEmail(student.getEmail());
        return student;
    }

    public void deleteStudent(int id) {
        Student student = getStudentById(id);
        students.remove(student);
    }
}
