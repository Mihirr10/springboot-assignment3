package com.springboot.assignment3.controller;

import com.springboot.assignment3.entities.Student;
import com.springboot.assignment3.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {


  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents() {

    List<Student> students = this.studentService.getAllStudent();
    return ResponseEntity.status(HttpStatus.OK).body(students);

  }


  @PostMapping
  public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {

    Student createdStudent = studentService.createStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {

    Student student = studentService.getStudentById(id);
    return ResponseEntity.status(HttpStatus.OK).body(student);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {

    student.setId(id);
    Student updatedStudent = studentService.updateStudent(student);
    return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {

    studentService.deleteStudent(id);
    return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");
  }
}
