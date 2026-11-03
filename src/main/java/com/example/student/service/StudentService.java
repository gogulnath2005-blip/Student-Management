package com.example.student.service;

import com.example.student.dao.StudentDAO;
import com.example.student.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public boolean addStudent(Student student) throws SQLException {

        validateStudent(student);
        return studentDAO.addStudent(student);
    }

    public List<Student> getAllStudents() throws SQLException {
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than zero.");
        }

        return studentDAO.getStudentById(id);
    }

    public boolean updateStudent(Student student) throws SQLException {

        if (student.getId() <= 0) {
            throw new IllegalArgumentException("Invalid student ID.");
        }

        validateStudent(student);
        return studentDAO.updateStudent(student);
    }

    public boolean deleteStudent(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException("Invalid student ID.");
        }

        return studentDAO.deleteStudent(id);
    }

    private void validateStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }

        if (student.getName() == null || student.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }

        if (student.getEmail() == null || student.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }

        if (student.getCourse() == null || student.getCourse().isBlank()) {
            throw new IllegalArgumentException("Course is required.");
        }

        if (student.getAge() < 16 || student.getAge() > 100) {
            throw new IllegalArgumentException("Age must be between 16 and 100.");
        }
    }
}