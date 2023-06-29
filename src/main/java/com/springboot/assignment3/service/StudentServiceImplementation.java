package com.springboot.assignment3.service;


import com.springboot.assignment3.entities.Student;
import com.springboot.assignment3.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class StudentServiceImplementation implements StudentService {




  private final StudentRepository studentRepository;

  @Autowired
  public StudentServiceImplementation(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student createStudent(Student student) {

     if(student != null){
       log.info("creating student");
       return studentRepository.save(student);
     }
     else{
       log.warn("please enter valid details");
       throw new RuntimeException("failed to create student");
     }


  }

  @Override
  public List<Student> getAllStudent() {

      log.info("getting all students");
      return studentRepository.findAll();


  }

  @Override
  public Student getStudentById(Integer id) {

      Optional<Student> student = studentRepository.findById(id);
      if (student.isPresent()) {
        return student.get();
      }else{
        log.warn("please enter valid id");
        throw new RuntimeException("Id not found");
      }
  }


  @Override
  public Student updateStudent(Student student) {

    log.info("creating student");
    return studentRepository.save(student);
  }


  @Override
  public void deleteStudent(Integer id) {

      Optional<Student> s = studentRepository.findById(id);
      if (s.isPresent()) {
        studentRepository.delete(s.get());
        log.info("Student deleted successfully");
      }
      else {
        log.error("exception occurred while deleting student");
        throw new RuntimeException("failed to delete student");
    }
    }

}
