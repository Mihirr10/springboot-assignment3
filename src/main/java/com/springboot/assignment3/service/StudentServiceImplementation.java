package com.springboot.assignment3.service;


import com.springboot.assignment3.entities.Student;
import com.springboot.assignment3.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceImplementation implements StudentService {

  private static final Logger logger = LoggerFactory.getLogger(StudentServiceImplementation.class);


  private final StudentRepository studentRepository;

  @Autowired
  public StudentServiceImplementation(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student createStudent(Student student) {
    try {
      return studentRepository.save(student);
    } catch (Exception e) {
      logger.error("exception occurred while creating an student");
      throw new RuntimeException("failed to create the student");
    }
  }

  @Override
  public List<Student> getAllStudent() {
    try {
      return studentRepository.findAll();
    } catch (Exception e) {
      logger.error("exception occurred while retrieving  the student");
      throw new RuntimeException("failed to get all students");
    }
  }

  @Override
  public Student getStudentById(Integer id) {
    try {

      Optional<Student> student = studentRepository.findById(id);
      if (student.isPresent()) {
        return student.get();
      }
    } catch (Exception e) {
      logger.warn("please enter valid id");
      throw new RuntimeException(e);
    }

    return null;
  }


  @Override
  public Student updateStudent(Student student) {
    try {
      return studentRepository.save(student);
    } catch (Exception e) {
      logger.error("exception occurred while updating student");
      throw new RuntimeException("failed to update student");
    }
  }


  @Override
  public void deleteStudent(Integer id) {
    try {
      Optional<Student> s = studentRepository.findById(id);
      if (s.isPresent()) {
        studentRepository.delete(s.get());
        logger.info("Student deleted successfully");
      }

    } catch (Exception e) {
      logger.error("exception occurred while deleting student");
      throw new RuntimeException("failed to delete student");
    }
  }
}
