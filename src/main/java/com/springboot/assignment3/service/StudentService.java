package com.springboot.assignment3.service;

import com.springboot.assignment3.entities.Student;

import java.util.List;

public interface StudentService {
  public Student createStudent(Student student);

  public List<Student> getAllStudent();

  public Student getStudentById(Integer id);

  public Student updateStudent(Student student);

  public void deleteStudent(Integer id);
}
