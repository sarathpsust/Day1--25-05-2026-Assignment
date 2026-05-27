package com.stuent.service;

import com.example.studentmanagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final Map<Long, Student> studentDB = new HashMap<>();

    public Student addStudent(Student student) {
        studentDB.put(student.getId(), student);
        return student;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDB.values());
    }

    public Student getStudentById(Long id) {
        return studentDB.get(id);
    }

    public String updateStudent(Long id, Student updatedStudent) {
        if (!studentDB.containsKey(id)) {
            return "Student not found";
        }

        updatedStudent.setId(id);
        studentDB.put(id, updatedStudent);
        return "Student updated successfully";
    }

    public String deleteStudent(Long id) {
        if (!studentDB.containsKey(id)) {
            return "Student not found";
        }

        studentDB.remove(id);
        return "Student deleted successfully";
    }
}